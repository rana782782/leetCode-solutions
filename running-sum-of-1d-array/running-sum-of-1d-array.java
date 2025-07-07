// LeetCode: Running Sum of 1d Array (running-sum-of-1d-array)
// Submission ID: 1689562510
// Language: java
// Timestamp (UTC): 2025-07-07T13:03:02Z

class Solution {
    public int[] runningSum(int[] nums) {
        int length = nums.length;
         int output[] = new int[length];
        
        int currSum =0;
        
        for(int i = 0; i<nums.length; i++){
            currSum+=nums[i];
            
            output[i] = currSum;
        }
        
        return output;
    }
}