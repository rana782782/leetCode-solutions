// LeetCode: Unique Paths II (unique-paths-ii)
// Submission ID: 1428080139
// Language: java
// Timestamp (UTC): 2024-10-20T06:33:13Z

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        if(obstacleGrid[0][0] == 1 || obstacleGrid[m-1][n-1] == 1){
            return 0;
        }

        int dp[][] = new int[m][n];
        for(int i = m-1; i>=0; i--){
            for(int j = n-1; j>=0; j--){
                if(obstacleGrid[i][j] == 1){
                    dp[i][j] = 0;
                }
                else{
                    if(i == m-1 && j ==n-1){
                        dp[i][j] = 1;

                    }
                    else if(i == m-1){
                        dp[i][j] = dp[i][j+1];
                    }
                    else if(j == n-1){
                        dp[i][j] = dp[i+1][j];
                    }
                    else{
                        dp[i][j] = dp[i+1][j]+dp[i][j+1];
                    }
                }
            }
        }

        return dp[0][0];

    }
}