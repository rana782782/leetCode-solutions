// LeetCode: Maximum Ice Cream Bars (maximum-ice-cream-bars)
// Submission ID: 1597531041
// Language: java
// Timestamp (UTC): 2025-04-05T14:26:01Z

class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
   int ans = 0;
        for(int ele : costs){

            if(coins == 0) return ans;
            if(coins-ele>=0){
                coins-=ele;
                ans++;
            }
        }

        return ans;
    }
}