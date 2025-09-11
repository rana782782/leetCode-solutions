// LeetCode: Sum of Subsequence Widths (sum-of-subsequence-widths)
// Submission ID: 1767055740
// Language: java
// Timestamp (UTC): 2025-09-11T10:38:31Z

import java.util.*;

class Solution {
    private static final int MOD = 1_000_000_007;

    public int sumSubseqWidths(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        long[] pow2 = new long[n];
        pow2[0] = 1;
        for (int i = 1; i < n; ++i) pow2[i] = (pow2[i - 1] * 2) % MOD;

        long ans = 0;
        for (int i = 0; i < n; ++i) {
            long add = (pow2[i] - pow2[n - 1 - i]) % MOD;
            if (add < 0) add += MOD;
            ans = (ans + nums[i] * add) % MOD;
        }
        return (int) ans;
    }
}
