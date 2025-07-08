// LeetCode: Maximum Subarray (maximum-subarray)
// Submission ID: 1691316694
// Language: java
// Timestamp (UTC): 2025-07-08T21:57:36Z

class Solution {
    public int maxSubArray(int[] nums) {
        int currSum = nums[0];
        int overAllSum = nums[0];
        
        for(int i = 1; i<nums.length; i++){
            
            if(currSum+nums[i]>nums[i]){
                currSum+=nums[i];
                overAllSum = Math.max(overAllSum,currSum);
            }
            else{
                currSum = nums[i];
                overAllSum = Math.max(overAllSum,currSum);
            }
        }
        
        return overAllSum;
    }
}