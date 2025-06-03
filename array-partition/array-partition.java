// LeetCode: Array Partition (array-partition)
// Submission ID: 1652915207
// Language: java
// Timestamp (UTC): 2025-06-03T16:50:32Z

class Solution {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        
        int sum = 0;
        for(int i = 0; i<nums.length; i+=2){
            sum+=nums[i];
        }
        
        return sum;
    }
}