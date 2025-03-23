// LeetCode: Number of Ways to Stay in the Same Place After Some Steps (number-of-ways-to-stay-in-the-same-place-after-some-steps)
// Submission ID: 1583196733
// Language: java
// Timestamp (UTC): 2025-03-23T10:16:37Z

class Solution {
    static final int MOD = 1000000007;
    static HashMap<String, Integer> map;

    public static int solution(int idx, int steps, int arrLen) {
        if (steps < 0) return 0;
        if (steps == 0) return (idx == 0) ? 1 : 0;

        String key = idx + "_" + steps;
        if (map.containsKey(key)) return map.get(key);

        long ans1 = 0, ans2 = 0, ans3 = 0;

        // Move right
        if (idx + 1 < arrLen) ans1 = solution(idx + 1, steps - 1, arrLen);

        // Move left
        if (idx - 1 >= 0) ans2 = solution(idx - 1, steps - 1, arrLen);

        // Stay in place
        ans3 = solution(idx, steps - 1, arrLen);

        // Calculate total and store it with modulo to prevent overflow
        long total = (ans1 + ans2 + ans3) % MOD;

        map.put(key, (int) total);  // Store as int after modulo
        return (int) total;
    }

    public int numWays(int steps, int arrLen) {
        map = new HashMap<>();

        // Limit array length to steps/2 + 1
        arrLen = Math.min(arrLen, steps / 2 + 1);

        return solution(0, steps, arrLen);
    }
}
