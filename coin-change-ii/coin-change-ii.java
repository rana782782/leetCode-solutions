// LeetCode: Coin Change II (coin-change-ii)
// Submission ID: 1574672703
// Language: java
// Timestamp (UTC): 2025-03-15T16:02:18Z

class Solution {
    static int memo[][];

    public static int solution(int coins[], int idx, int amount){
        if(idx>=coins.length || amount<0) return 0;

        if(amount == 0) return 1;

        if(memo[idx][amount]!=-1) return memo[idx][amount];

        int taken = solution(coins,idx,amount-coins[idx]);
        int not_taken = solution(coins,idx+1,amount);

        return memo[idx][amount] = taken+not_taken;
    }
    public int change(int amount, int[] coins) {
        memo = new int[coins.length][amount+1];
        for(int i = 0; i<memo.length; i++){
            Arrays.fill(memo[i],-1);
        }
        return solution(coins,0,amount);
    }
}