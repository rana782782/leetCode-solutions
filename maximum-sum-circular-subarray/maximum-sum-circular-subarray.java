// LeetCode: Maximum Sum Circular Subarray (maximum-sum-circular-subarray)
// Submission ID: 1768206883
// Language: java
// Timestamp (UTC): 2025-09-12T11:46:40Z

class Solution {
    private int kadaneMax(int[] nums) {
        int curr = nums[0], best = nums[0];
        for (int i = 1; i < nums.length; i++) {
            curr = Math.max(nums[i], curr + nums[i]);
            best = Math.max(best, curr);
        }
        return best;
    }

    private int kadaneMin(int[] nums) {
        int curr = nums[0], best = nums[0];
        for (int i = 1; i < nums.length; i++) {
            curr = Math.min(nums[i], curr + nums[i]);
            best = Math.min(best, curr);
        }
        return best;
    }

    public int maxSubarraySumCircular(int[] nums) {
        int maxKadane = kadaneMax(nums);
        if (maxKadane < 0) return maxKadane;

        int total = 0;
        for (int v : nums) total += v;

        int minKadane = kadaneMin(nums);
        int circularMax = total - minKadane;

        return Math.max(maxKadane, circularMax);
    }
}
