// LeetCode: Best Time to Buy and Sell Stock with Cooldown (best-time-to-buy-and-sell-stock-with-cooldown)
// Submission ID: 1426164892
// Language: java
// Timestamp (UTC): 2024-10-18T07:14:02Z

class Solution {
    public int maxProfit(int[] prices) {
        int obsp = -prices[0];
        int ossp = 0;
        int ocsp = 0;

        for(int i = 0; i<prices.length; i++){
            int nbsp = 0;
             int nssp = 0;
              int ncsp = 0;
              nbsp = Math.max(ocsp-prices[i],obsp);
              nssp = Math.max(prices[i]+obsp,ossp);
              ncsp = Math.max(ocsp,ossp);
              obsp = nbsp;
              ossp = nssp;
              ocsp = ncsp;
        }

        return ossp;
    }
}