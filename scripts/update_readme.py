import os, re, datetime
from pathlib import Path

import requests
from pytz import timezone

USERNAME = os.getenv("LC_USERNAME", "rana_782")
TZ = os.getenv("TZ_REGION", "Asia/Kolkata")
URL = "https://leetcode.com/graphql"

QUERY = """
query userData($username: String!) {
  matchedUser(username: $username) {
    username
    submitStats { acSubmissionNum { difficulty count submissions } }
    profile { ranking }
    badges { name }
  }
  userContestRanking(username: $username) {
    rating
    attendedContestsCount
  }
}
"""

def fetch_stats(username: str):
    r = requests.post(URL, json={"query": QUERY, "variables": {"username": username}}, timeout=30)
    r.raise_for_status()
    data = r.json()["data"]

    mu = data["matchedUser"]
    ac = {x["difficulty"]: x for x in mu["submitStats"]["acSubmissionNum"]}
    all_ = ac["All"]["count"]
    easy = ac["Easy"]["count"]
    medium = ac["Medium"]["count"]
    hard = ac["Hard"]["count"]

    rank = mu["profile"]["ranking"]
    badges = ", ".join([b["name"] for b in mu.get("badges") or []][:6])

    cr = data.get("userContestRanking") or {}
    rating = cr.get("rating")
    contests = cr.get("attendedContestsCount") or 0

    return {
        "user": username,
        "solved": all_,
        "easy": easy, "medium": medium, "hard": hard,
        "rank": rank,
        "rating": f"{rating:.2f}" if rating else None,
        "contests": contests,
        "badges": badges
    }

def render(stats):
    now = datetime.datetime.now(timezone(TZ)).strftime("%d %b %Y, %I:%M %p %Z")
    lines = [
        f"**User:** `{stats['user']}`",
        "",
        f"- ✅ **Solved:** {stats['solved']} (Easy {stats['easy']} · Med {stats['medium']} · Hard {stats['hard']})",
        f"- 🏆 **Global Rank:** {stats['rank']}",
    ]
    if stats["rating"]:
        lines.append(f"- 📈 **Contest Rating:** {stats['rating']}  ·  **Contests:** {stats['contests']}")
    if stats["badges"]:
        lines.append(f"- 🎖️ **Badges:** {stats['badges']}")
    lines += ["", f"_Last updated: {now}_"]
    return "\n".join(lines)

def main():
    root = Path(__file__).resolve().parents[1]
    readme = root / "README.md"
    text = readme.read_text(encoding="utf-8")

    stats = fetch_stats(USERNAME)
    block = render(stats)

    pattern = r"(<!--LEETCODE_STATS_START-->)(.*?)(<!--LEETCODE_STATS_END-->)"
    new_text = re.sub(pattern, r"\1\n" + block + r"\n\3", text, flags=re.S)

    if new_text != text:
        readme.write_text(new_text, encoding="utf-8")
        print("README updated.")
    else:
        print("No changes.")

if __name__ == "__main__":
    main()
