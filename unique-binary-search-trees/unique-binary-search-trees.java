// LeetCode: Unique Binary Search Trees (unique-binary-search-trees)
// Submission ID: 1438181723
// Language: java
// Timestamp (UTC): 2024-10-30T12:48:46Z

class Solution {
    public int numTrees(int n) {
        int dp[] = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;

        for(int i = 2; i<=n; i++){
            int sum = 0;
            for(int j = 0; j<i; j++){
                sum+=(dp[j]*dp[i-j-1]);
            }
            dp[i] = sum;
        }

        return dp[n];
    }
}