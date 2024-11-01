// LeetCode: Distinct Subsequences II (distinct-subsequences-ii)
// Submission ID: 1439935062
// Language: java
// Timestamp (UTC): 2024-11-01T14:17:21Z

class Solution {
    public int distinctSubseqII(String s) {
        
        int mod = 1000000007;

        HashMap<Character, Integer> map = new HashMap<>();
        long dp[] = new long[s.length() + 1];

        dp[0] = 1; // Base case: the empty subsequence

        for (int i = 1; i < dp.length; i++) {
            dp[i] = (dp[i - 1] * 2) % mod;
            char ch = s.charAt(i - 1);

            if (map.containsKey(ch)) {
                int j = map.get(ch);
                // Subtract the value of dp[j - 1] and adjust for negative values
                dp[i] = (dp[i] - dp[j - 1] + mod) % mod;
            }

            map.put(ch, i);
        }

        // Ensure the final result is non-negative by taking mod again if needed
        return (int)((dp[s.length()] - 1 + mod) % mod);
    }
}
