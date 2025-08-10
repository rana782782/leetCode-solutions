// LeetCode: Flip Square Submatrix Vertically (flip-square-submatrix-vertically)
// Submission ID: 1730029280
// Language: java
// Timestamp (UTC): 2025-08-10T11:18:07Z

class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        int m = grid.length;
        int n = grid[0].length;

        int backRow = Math.min(m-1,x+k-1);
        int temRow = backRow;

        for(int row = x; row<=(x+temRow)/2; row++){
            for(int col = y; col<y+k; col++){
                int temp = grid[row][col];
                grid[row][col] = grid[backRow][col];
                grid[backRow][col] = temp;
            }
            backRow--;
        }

        return grid;
    }
}