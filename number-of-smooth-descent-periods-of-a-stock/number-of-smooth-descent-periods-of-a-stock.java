// LeetCode: Number of Smooth Descent Periods of a Stock (number-of-smooth-descent-periods-of-a-stock)
// Submission ID: 1732380158
// Language: java
// Timestamp (UTC): 2025-08-12T11:47:29Z

class Solution {
    public long getDescentPeriods(int[] prices) {
        int n = prices.length;
        int dp[] = new int[n];

        dp[n-1] = n-1;

        for(int i = n-2; i>=0; i--){
            if(prices[i]-prices[i+1] == 1)dp[i] = dp[i+1];
            else{
                dp[i] = i;
            }
        }

        long output = 0;

        for(int i = 0; i<n; i++){
            output+=(dp[i]-i)+1;
        }

        return output;
    }
}