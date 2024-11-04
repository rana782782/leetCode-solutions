// LeetCode: Arithmetic Slices (arithmetic-slices)
// Submission ID: 1442689973
// Language: java
// Timestamp (UTC): 2024-11-04T11:47:03Z

class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums.length<=2){
            return 0;
        }
        int dp[] = new int[nums.length];
        dp[0] = 0;
        dp[1] = 0;
              int sum = 0;
        for(int i = 2; i<nums.length; i++){
             if(nums[i]-nums[i-1] == nums[i-1]-nums[i-2]){
                dp[i]=dp[i-1]+1;
             }
             else{
                dp[i] = 0;
             }

             sum+=dp[i];
        }

        return sum;
    }
}