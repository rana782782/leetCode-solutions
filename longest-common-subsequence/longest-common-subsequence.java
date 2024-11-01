// LeetCode: Longest Common Subsequence (longest-common-subsequence)
// Submission ID: 1439628409
// Language: java
// Timestamp (UTC): 2024-11-01T06:26:22Z

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int dp[][] = new int[n+1][m+1];

        for(int i = n-1; i>=0; i--){
            for(int j = m-1; j>=0; j--){
                char ch1 = text1.charAt(i);
                char ch2 = text2.charAt(j);

                if(i == n-1 || j == m-1){
                    dp[i][j] = 0;
                }

                if(ch1 == ch2){
                    dp[i][j] = 1+dp[i+1][j+1];
                }

                else{
                    dp[i][j] = Math.max(dp[i+1][j],dp[i][j+1]);
                }
            }
        }

        return dp[0][0];
    }
}