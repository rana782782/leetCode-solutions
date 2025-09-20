// LeetCode: Maximize Sum Of Array After K Negations (maximize-sum-of-array-after-k-negations)
// Submission ID: 1776902991
// Language: java
// Timestamp (UTC): 2025-09-20T10:22:18Z

class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);

        int output = 0;
        int idx = 0;

        while(idx<nums.length && k>0 && nums[idx]<0){
           nums[idx] = Math.abs(nums[idx]);
            idx++;
            k--;
        }

        int curr_sum = 0;
        int minAbs = Integer.MAX_VALUE;

        for(int ele : nums){
            curr_sum+=ele;
                    minAbs = Math.min(minAbs,Math.abs(ele));
        }


        if(k>0 && k%2 == 1){
            curr_sum+=(-1)*minAbs*2;
        }

        return curr_sum;


    }
}