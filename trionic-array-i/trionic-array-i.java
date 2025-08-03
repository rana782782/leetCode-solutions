// LeetCode: Trionic Array I (trionic-array-i)
// Submission ID: 1721814985
// Language: java
// Timestamp (UTC): 2025-08-03T11:35:49Z

class Solution {
    public boolean isTrionic(int[] nums) {
        int p = 0;
         int q = 0;
          int i = 0;

        // find p

        while(i<nums.length-1){
           if(nums[i+1]<=nums[i])break;
           i++;
        }

        if(i == nums.length-1 || i == 0)return false;
        p = i;

        //find q

            while(i<nums.length-1){
                if(nums[i]<=nums[i+1])break;
                i++;
            }

            if(i == p || i == nums.length-1)return false;
            q = i;

            while(i<nums.length-1){
                if(nums[i]>=nums[i+1])break;
                i++;
            }

            if(i == q || i<nums.length-1)return false;

            return true;

    }
}