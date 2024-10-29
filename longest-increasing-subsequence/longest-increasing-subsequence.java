// LeetCode: Longest Increasing Subsequence (longest-increasing-subsequence)
// Submission ID: 1437168197
// Language: java
// Timestamp (UTC): 2024-10-29T11:18:05Z

class Solution {
    public int lengthOfLIS(int[] nums) {
        int output = 1;

        int dp[] = new int[nums.length];
        dp[0] = 1;

        for(int i = 1; i<dp.length; i++){
            int max = 0;
            for(int j = 0; j<i; j++){
                   int givenNum = nums[i];

                   if(givenNum>nums[j]){
                    max = Math.max(max,dp[j]);
                   }
            }

            dp[i] = max+1;
            output = Math.max(output,dp[i]);
        }

        return output;
    }
}