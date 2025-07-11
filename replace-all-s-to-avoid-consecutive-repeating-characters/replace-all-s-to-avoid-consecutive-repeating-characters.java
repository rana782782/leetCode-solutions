// LeetCode: Replace All ?'s to Avoid Consecutive Repeating Characters (replace-all-s-to-avoid-consecutive-repeating-characters)
// Submission ID: 1693778565
// Language: java
// Timestamp (UTC): 2025-07-11T03:03:32Z

class Solution {
    static String output;

    public static void solution(int idx, String s, StringBuilder currStr) {
        if (idx == s.length()) {
            output = currStr.toString();
            return;
        }

        char ch = s.charAt(idx);

        if (ch == '?') {
            for (char rep = 'a'; rep <= 'z'; rep++) {
                if ((idx == 0 || currStr.charAt(idx - 1) != rep) &&
                    (idx == s.length() - 1 || s.charAt(idx + 1) != rep)) {

                    currStr.append(rep);
                    solution(idx + 1, s, currStr);
                    currStr.deleteCharAt(currStr.length() - 1); // backtrack
                    if (!output.isEmpty()) return; // early exit if already found
                }
            }
        } else {
            currStr.append(ch);
            solution(idx + 1, s, currStr);
            currStr.deleteCharAt(currStr.length() - 1); // backtrack
        }
    }

    public String modifyString(String s) {
        if (s.length() == 1) {
            return s.equals("?") ? "a" : s;
        }

        output = "";
        solution(0, s, new StringBuilder());
        return output;
    }
}
