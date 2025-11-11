import java.util.Arrays;

class Solution {
    public int maxPathScore(int[][] grid, int K) {
        int m = grid.length;
        int n = grid[0].length;
        int k = K;
        final int NEG = Integer.MIN_VALUE/4; 

        int[][][] dp = new int[m][n][k + 1];
        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j)
                Arrays.fill(dp[i][j], NEG);

        dp[0][0][k] = 0; 

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                for (int rem = 0; rem <= k; ++rem) {
                    int cur = dp[i][j][rem];
                    if (cur == NEG) continue;

                  
                    int ni = i, nj = j + 1;
                    if (nj < n) {
                        int val = grid[ni][nj];
                        if (val == 0) {
                            dp[ni][nj][rem] = Math.max(dp[ni][nj][rem], cur);
                        } else if (rem > 0) {
                            dp[ni][nj][rem - 1] = Math.max(dp[ni][nj][rem - 1], cur + val);
                        }
                    }

                    
                    ni = i + 1; nj = j;
                    if (ni < m) {
                        int val = grid[ni][nj];
                        if (val == 0) {
                            dp[ni][nj][rem] = Math.max(dp[ni][nj][rem], cur);
                        } else if (rem > 0) {
                            dp[ni][nj][rem - 1] = Math.max(dp[ni][nj][rem - 1], cur + val);
                        }
                    }
                }
            }
        }

        int ans = NEG;
        for (int rem = 0; rem <= k; ++rem) ans = Math.max(ans, dp[m-1][n-1][rem]);
        return ans == NEG ? -1 : ans;
    }
}
