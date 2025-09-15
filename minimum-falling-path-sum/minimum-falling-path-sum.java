// LeetCode: Minimum Falling Path Sum (minimum-falling-path-sum)
// Submission ID: 1771607052
// Language: java
// Timestamp (UTC): 2025-09-15T13:31:07Z

class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int dp[][] = new int[matrix.length][matrix[0].length];

        int ans = Integer.MAX_VALUE;

        for(int i = dp.length-1; i>=0; i--){
            for(int j = dp[0].length-1; j>=0; j--){

                if(i == dp.length-1){
                    dp[i][j] = matrix[i][j];
                }

                else if(j == dp[0].length-1){
                    dp[i][j] = Math.min(dp[i+1][j-1],dp[i+1][j])+matrix[i][j];
                }

                else if(j == 0){
                    dp[i][j] = Math.min(dp[i+1][j+1],dp[i+1][j])+matrix[i][j];
                }

                else{
                    dp[i][j] = Math.min(dp[i+1][j],Math.min(dp[i+1][j-1],dp[i+1][j+1]))+matrix[i][j];
                }
if(i == 0){
    ans = Math.min(ans,dp[i][j]);
}
                
            }
        }
   

        return ans;
    }
}