// LeetCode: Triangle (triangle)
// Submission ID: 1782186304
// Language: java
// Timestamp (UTC): 2025-09-25T10:11:35Z

import java.util.*;

class Solution {
    static int[][] memo;

    private static int dfs(int r, int c, List<List<Integer>> t) {
        int n = t.size();
        if (r == n - 1) return t.get(r).get(c);
        if (memo[r][c] != Integer.MIN_VALUE) return memo[r][c];

        int val = t.get(r).get(c);
        // only two legal moves: down (r+1, c) and down-right (r+1, c+1)
        int left = dfs(r + 1, c, t);
        int right = dfs(r + 1, c + 1, t);
        memo[r][c] = val + Math.min(left, right);
        return memo[r][c];
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        memo = new int[n][n];
        for (int i = 0; i < n; i++) Arrays.fill(memo[i], Integer.MIN_VALUE);
        return dfs(0, 0, triangle);
    }

}
