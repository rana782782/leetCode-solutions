// LeetCode: Best Time to Buy and Sell Stock with Transaction Fee (best-time-to-buy-and-sell-stock-with-transaction-fee)
// Submission ID: 1425431335
// Language: java
// Timestamp (UTC): 2024-10-17T14:20:24Z

class Solution {
    public int maxProfit(int[] prices, int fee) {
        int obsp = -prices[0];
        int ossp = 0;
        

         for(int i = 1; i<prices.length; i++){

            int nbsp = 0;
         int nssp = 0;
            if(ossp-prices[i]>obsp){
                nbsp = ossp-prices[i];
            }
            else{
                nbsp = obsp;
            }

            if(obsp+prices[i]-fee>ossp){
                nssp = obsp+prices[i]-fee;
            }
            else{
                nssp = ossp;
            }

            obsp = nbsp;
            ossp = nssp;
         }

         return ossp;
    }
}