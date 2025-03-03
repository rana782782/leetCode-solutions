// LeetCode: Ugly Number II (ugly-number-ii)
// Submission ID: 1561443158
// Language: java
// Timestamp (UTC): 2025-03-03T13:27:11Z

class Solution {
    public int nthUglyNumber(int n) {
        int dp[] = new int[n+1];
        dp[1] = 1;

        int p2 = 1;
        int p3= 1;
         int p5  = 1;


         for(int i = 2; i<=n; i++){
            int f1 = dp[p2]*2;
            int f2 = dp[p3]*3;
            int f3 = dp[p5]*5;

            int minima = Math.min(f1,Math.min(f2,f3));

            dp[i] = minima;

            if(minima == f1){
                p2++;
            }
            if(minima == f2){
                p3++;
            }
            if(minima == f3){
                p5++;
            }
         }

         return dp[n];
    }
}