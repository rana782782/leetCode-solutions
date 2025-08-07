// LeetCode: Majority Element (majority-element)
// Submission ID: 1727215867
// Language: java
// Timestamp (UTC): 2025-08-07T18:20:39Z

class Solution {
    public int majorityElement(int[] nums) {
        int curr_ele = nums[0];
        int curr_len = 1;

        for(int i = 1; i<nums.length; i++){
            if(curr_len == 0){
                curr_ele = nums[i];
                curr_len = 1;
            }
            else{
                if(nums[i] == curr_ele)curr_len++;
                else{
                    curr_len--;
                }
            }
        }

        return curr_ele;
    }
}