// LeetCode: Sort Array By Parity II (sort-array-by-parity-ii)
// Submission ID: 1769054812
// Language: java
// Timestamp (UTC): 2025-09-13T08:21:47Z

class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        int n = nums.length;
        int pos = 0;
        int neg = 1;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            if (nums[i] % 2 == 0) {
                ans[pos] = nums[i];
                pos += 2;
            } else {
                ans[neg] = nums[i];
                neg += 2;
            }
        }
        return ans;
    }
}