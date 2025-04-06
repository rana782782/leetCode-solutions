// LeetCode: Maximum Number of Coins You Can Get (maximum-number-of-coins-you-can-get)
// Submission ID: 1598855960
// Language: java
// Timestamp (UTC): 2025-04-06T19:08:37Z

class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);

        int output = 0;


        int n = piles.length/3;
        int idx = piles.length-2;
        while(n!=0){
            output+=piles[idx];
            idx-=2;
            n--;
        }

        return output;
    }
}