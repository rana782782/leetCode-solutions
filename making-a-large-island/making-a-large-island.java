// LeetCode: Making A Large Island (making-a-large-island)
// Submission ID: 1760390561
// Language: java
// Timestamp (UTC): 2025-09-05T11:25:15Z

class Solution {
    private int n;
    private int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    private int[][] islandIds;
    private int[] islandSizes;
    private int islandId = 0;

    public int largestIsland(int[][] grid) {
        n = grid.length;
        islandIds = new int[n][n];
        islandSizes = new int[n*n + 1];
        
        // Step 1: Mark islands with ids and store their sizes
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (grid[i][j] == 1 && islandIds[i][j] == 0) {
                    islandId++;
                    islandSizes[islandId] = dfs(grid, i, j);
                }
            }
        }
        
        int maxIsland = 0;
        for (int size : islandSizes) {
            maxIsland = Math.max(maxIsland, size);
        }
        
        // Step 2: Try flipping each zero and calculate reachable island size
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (grid[i][j] == 0) {
                    HashSet<Integer> seen = new HashSet<>();
                    int possibleSize = 1;
                    for (int[] dir : dirs) {
                        int ni = i + dir[0], nj = j + dir[1];
                        if (ni >= 0 && nj >= 0 && ni < n && nj < n && islandIds[ni][nj] != 0) {
                            if (!seen.contains(islandIds[ni][nj])) {
                                possibleSize += islandSizes[islandIds[ni][nj]];
                                seen.add(islandIds[ni][nj]);
                            }
                        }
                    }
                    maxIsland = Math.max(maxIsland, possibleSize);
                }
            }
        }
        return maxIsland;
    }

    private int dfs(int[][] grid, int i, int j) {
        islandIds[i][j] = islandId;
        int size = 1;
        for (int[] dir : dirs) {
            int ni = i + dir[0], nj = j + dir[1];
            if (ni >= 0 && nj >= 0 && ni < n && nj < n) {
                if (grid[ni][nj] == 1 && islandIds[ni][nj] == 0) {
                    size += dfs(grid, ni, nj);
                }
            }
        }
        return size;
    }
}
