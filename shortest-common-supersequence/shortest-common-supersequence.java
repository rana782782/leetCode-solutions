// LeetCode: Shortest Common Supersequence  (shortest-common-supersequence)
// Submission ID: 1692711672
// Language: java
// Timestamp (UTC): 2025-07-10T04:45:43Z

class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int n = str1.length(), m = str2.length();
        
        // Step 1: Compute LCS dp table
        int[][] dp = new int[n+1][m+1];
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(str1.charAt(i-1) == str2.charAt(j-1))
                    dp[i][j] = 1 + dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }

        // Step 2: Build SCS from dp table
        StringBuilder sb = new StringBuilder();
        int i = n, j = m;

        while(i > 0 && j > 0){
            if(str1.charAt(i-1) == str2.charAt(j-1)){
                sb.append(str1.charAt(i-1));
                i--; j--;
            }
            else if(dp[i-1][j] > dp[i][j-1]){
                sb.append(str1.charAt(i-1));
                i--;
            } else {
                sb.append(str2.charAt(j-1));
                j--;
            }
        }

        // Add remaining characters
        while(i > 0) sb.append(str1.charAt(i-- -1));
        while(j > 0) sb.append(str2.charAt(j-- -1));

        return sb.reverse().toString();
    }
}
