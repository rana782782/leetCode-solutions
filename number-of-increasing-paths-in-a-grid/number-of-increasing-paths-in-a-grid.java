// LeetCode: Number of Increasing Paths in a Grid (number-of-increasing-paths-in-a-grid)
// Submission ID: 1570001865
// Language: java
// Timestamp (UTC): 2025-03-11T07:25:13Z

import java.util.Arrays;

class Solution {
    static int[][] memo;
    static final int MOD = 1_000_000_007;
    static final int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};

    public static int solution(int[][] grid, int i, int j) {
        if (memo[i][j] != -1) return memo[i][j];

        int result = 1; // Each cell is itself a path

        for (int[] d : dir) {
            int nRow = i + d[0];
            int nCol = j + d[1];

            if (nRow >= 0 && nRow < grid.length && nCol >= 0 && nCol < grid[0].length && grid[nRow][nCol] > grid[i][j]) {
                result = (result + solution(grid, nRow, nCol)) % MOD;
            }
        }

        return memo[i][j] = result;
    }

    public int countPaths(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        memo = new int[rows][cols];

        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        int output = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                output = (output + solution(grid, i, j)) % MOD;
            }
        }

        return output;
    }
}
