// LeetCode: Minimum Rounds to Complete All Tasks (minimum-rounds-to-complete-all-tasks)
// Submission ID: 1597515962
// Language: java
// Timestamp (UTC): 2025-04-05T14:06:51Z

class Solution {
    public int minimumRounds(int[] tasks) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int task : tasks) {
            freq.put(task, freq.getOrDefault(task, 0) + 1);
        }

        // Precompute min rounds for all frequencies up to maxFreq
        int maxFreq = Collections.max(freq.values());
        int[] dp = new int[maxFreq + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        if (maxFreq >= 2) dp[2] = 1;
        if (maxFreq >= 3) dp[3] = 1;

        for (int i = 4; i <= maxFreq; i++) {
            if (dp[i - 2] != Integer.MAX_VALUE)
                dp[i] = Math.min(dp[i], 1 + dp[i - 2]);
            if (dp[i - 3] != Integer.MAX_VALUE)
                dp[i] = Math.min(dp[i], 1 + dp[i - 3]);
        }

        int total = 0;
        for (int count : freq.values()) {
            if (count == 1) return -1;
            total += dp[count];
        }

        return total;
    }
}
