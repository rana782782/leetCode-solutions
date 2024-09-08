// LeetCode: Max Consecutive Ones (max-consecutive-ones)
// Submission ID: 1383258212
// Language: java
// Timestamp (UTC): 2024-09-08T13:52:31Z

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max_length = 0;
        int ones = 0;
        for(int i = 0; i<nums.length; i++){
            if(nums[i] == 1){
                ones++;
                max_length = Math.max(ones,max_length);
            }
            else{
                ones = 0;
            }
        }
        return max_length;
    }
}