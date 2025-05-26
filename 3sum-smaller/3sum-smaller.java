// LeetCode: 3Sum Smaller (3sum-smaller)
// Submission ID: 1644510616
// Language: java
// Timestamp (UTC): 2025-05-26T00:42:37Z

import java.util.Arrays;

class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int count = 0;

        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1, k = nums.length - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];

                if (sum < target) {
                    count += (k - j); 
                    j++;
                } else {
                    k--;
                }
            }
        }

        return count;
    }
}
