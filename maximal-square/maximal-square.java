// LeetCode: Maximal Square (maximal-square)
// Submission ID: 1436978344
// Language: java
// Timestamp (UTC): 2024-10-29T06:26:36Z

class Solution {
    public int maximalSquare(char[][] matrix) {
        int dp[][] = new int[matrix.length][matrix[0].length];
        int output = Integer.MIN_VALUE;

        for(int i = dp.length-1; i>=0; i--){
             for(int j =dp[0].length-1; j>=0; j--){
                if(i == matrix.length-1 || j == matrix[0].length-1){
                    dp[i][j] = matrix[i][j]-'0';
                }

              

               else if(matrix[i][j]-'0'!=0){
                    if(dp[i][j+1]!=0 &&dp[i+1][j]!=0 && dp[i+1][j+1]!=0){
                        dp[i][j] =Math.min(dp[i][j+1], Math.min(dp[i+1][j],dp[i+1][j+1]))+1;
                       
                    }
                    else{
                        dp[i][j] = 1;
                    }
                }

                else{
                    dp[i][j] = matrix[i][j]-'0';
                }
                 output = Math.max(output,dp[i][j]);
                System.out.println(dp[i][j]+" ");
             }

             
        }
        return output*output;
    }
}