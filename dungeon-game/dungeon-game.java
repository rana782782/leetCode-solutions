// LeetCode: Dungeon Game (dungeon-game)
// Submission ID: 1432093678
// Language: java
// Timestamp (UTC): 2024-10-24T04:46:32Z

class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;

        // DP table to store minimum HP required at each cell
        int[][] dp = new int[m][n];

        // Start from the bottom-right corner
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {

                // Bottom-right corner (princess' room)
                if (i == m - 1 && j == n - 1) {
                    dp[i][j] = Math.max(1, 1 - dungeon[i][j]);
                }

                // Last row: can only move right
                else if (i == m - 1) {
                    dp[i][j] = Math.max(1, dp[i][j + 1] - dungeon[i][j]);
                }

                // Last column: can only move down
                else if (j == n - 1) {
                    dp[i][j] = Math.max(1, dp[i + 1][j] - dungeon[i][j]);
                }

                // For other cells: can move either right or down
                else {
                    int minHealthOnExit = Math.min(dp[i + 1][j], dp[i][j + 1]);
                    dp[i][j] = Math.max(1, minHealthOnExit - dungeon[i][j]);
                }
            }
        }

        // Return the minimum HP required at the start cell
        return dp[0][0];
    }
}
