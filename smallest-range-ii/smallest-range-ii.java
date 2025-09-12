// LeetCode: Smallest Range II (smallest-range-ii)
// Submission ID: 1768161749
// Language: java
// Timestamp (UTC): 2025-09-12T10:42:21Z

class Solution {
    public int smallestRangeII(int[] nums, int k) {
        int n = nums.length;
        if (n <= 1) return 0;

        Arrays.sort(nums);
        int ans = nums[n-1] - nums[0]; 

  
        for (int i = 0; i < n - 1; ++i) {
            int high = Math.max(nums[n-1] - k, nums[i] + k);
            int low  = Math.min(nums[0] + k, nums[i+1] - k);
            ans = Math.min(ans, high - low);
        }
        return ans;
    }
}
