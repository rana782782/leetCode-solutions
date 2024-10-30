// LeetCode: Perfect Squares (perfect-squares)
// Submission ID: 1438156451
// Language: java
// Timestamp (UTC): 2024-10-30T12:06:02Z

class Solution {
    public int numSquares(int n) {
        int[]dp=new int[n+1];
        dp[0]=0;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            dp[i]=Integer.MAX_VALUE;
            for(int j=1;j*j<=i;j++){
                dp[i]=Math.min(dp[i],1+dp[i-j*j]);
            }
        }
        return dp[n];
    }
}