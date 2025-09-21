// LeetCode: Maximum Total Subarray Value I (maximum-total-subarray-value-i)
// Submission ID: 1778052999
// Language: java
// Timestamp (UTC): 2025-09-21T12:34:20Z

class Solution {
    public long maxTotalValue(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int ele : nums){
            max = Math.max(max,ele);
            min = Math.min(min,ele);
        }

        long diff = (long)max-(long)min;

        long ans = diff*k;
        return ans;
    }
}