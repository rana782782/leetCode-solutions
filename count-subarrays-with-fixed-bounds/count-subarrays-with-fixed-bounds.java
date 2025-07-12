// LeetCode: Count Subarrays With Fixed Bounds (count-subarrays-with-fixed-bounds)
// Submission ID: 1694851346
// Language: java
// Timestamp (UTC): 2025-07-12T04:28:51Z

class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long ans = 0;
        int minKPosition = -1;
        int maxKPosition = -1;
        int culpritIndex = -1;
        
        for(int i=0; i<nums.length; i++) {
            if(nums[i] < minK || nums[i] > maxK) {
                culpritIndex = i;
            }
            if(nums[i] == minK) {
                minKPosition = i;
            }
            if(nums[i] == maxK) {
                maxKPosition = i;
            }
            
            int smaller = Math.min(minKPosition, maxKPosition);
            long temp = smaller - culpritIndex;
            
            ans+= (temp <= 0) ? 0 : temp;
        }
        
        return ans;
    }
}