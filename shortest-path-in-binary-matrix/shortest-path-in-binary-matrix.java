// LeetCode: Shortest Path in Binary Matrix (shortest-path-in-binary-matrix)
// Submission ID: 1498526960
// Language: java
// Timestamp (UTC): 2025-01-05T13:18:44Z

class Solution {
 
    public static class Pair implements Comparable<Pair> {
        int row, col, wt;
        
        Pair(int row, int col, int wt) {
            this.row = row;
            this.col = col;
            this.wt = wt;
        }
        
        public int compareTo(Pair o) {
            return this.wt - o.wt;
        }
    }
    
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        
        // If starting or ending cell is blocked
        if (grid[0][0] == 1 || grid[n-1][n-1] == 1) {
            return -1;
        }
        
        // Directions for movement (8 directions)
        int[][] directions = {
            {-1, 0}, {1, 0}, {0, 1}, {0, -1}, // Cardinal
            {-1, 1}, {-1, -1}, {1, 1}, {1, -1} // Diagonal
        };
        
        // Priority queue for BFS with weighted paths
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, 0, 1));
        
        // Visited array
        boolean[][] visited = new boolean[n][n];
        visited[0][0] = true;
        
        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            
            // If we reach the bottom-right cell
            if (current.row == n - 1 && current.col == n - 1) {
                return current.wt;
            }
            
            // Explore neighbors
            for (int[] dir : directions) {
                int newRow = current.row + dir[0];
                int newCol = current.col + dir[1];
                
                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < n &&
                    grid[newRow][newCol] == 0 && !visited[newRow][newCol]) {
                    visited[newRow][newCol] = true;
                    pq.add(new Pair(newRow, newCol, current.wt + 1));
                }
            }
        }
        
        return -1; // If no path exists
    }
 }

