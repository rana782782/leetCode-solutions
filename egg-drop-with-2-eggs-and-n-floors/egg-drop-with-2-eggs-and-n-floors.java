// LeetCode: Egg Drop With 2 Eggs and N Floors (egg-drop-with-2-eggs-and-n-floors)
// Submission ID: 1442525160
// Language: java
// Timestamp (UTC): 2024-11-04T07:49:33Z

class Solution {
    public int twoEggDrop(int n) {
        int dp[][] = new int[3][n+1];

        for(int i = 1; i<dp.length; i++){
            for(int j = 1; j<dp[0].length; j++){

                if(i == 1){
                    dp[i][j] = j;
                }

                else if(j == 1){
                    dp[i][j] = 1;
                }

                else{
                    int min = Integer.MAX_VALUE;

                    for(int mj = j-1,pj = 0; mj>=0; mj--,pj++){
                        int val1 = dp[i][mj];
                        int val2 = dp[i-1][pj];
                        int max = Math.max(val1,val2);
                        min = Math.min(max,min);
                    }
                    dp[i][j] = min+1;
                }
            }
        }
        return dp[2][n];
    }
}