// LeetCode: Maximize Score After N Operations (maximize-score-after-n-operations)
// Submission ID: 1569090857
// Language: java
// Timestamp (UTC): 2025-03-10T12:43:36Z

import java.util.HashMap;
import java.util.Map;

class Solution {
    private final Map<Integer, Integer> memo = new HashMap<>();

    public int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public int solve(int nums[], int mask, int ops) {
        if (memo.containsKey(mask)) return memo.get(mask);

        int maxScore = 0;
        int n = nums.length;

        for (int i = 0; i < n - 1; i++) {
            if ((mask & (1 << i)) != 0) continue;

            for (int j = i + 1; j < n; j++) {
                if ((mask & (1 << j)) != 0) continue;

                int newMask = mask | (1 << i) | (1 << j);
                int currScore = ops * gcd(nums[i], nums[j]);
                int remScore = solve(nums, newMask, ops + 1);

                maxScore = Math.max(maxScore, currScore + remScore);
            }
        }

        memo.put(mask, maxScore);
        return maxScore;
    }

    public int maxScore(int[] nums) {
        return solve(nums, 0, 1);
    }
}
