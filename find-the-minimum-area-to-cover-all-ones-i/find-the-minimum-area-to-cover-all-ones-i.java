// LeetCode: Find the Minimum Area to Cover All Ones I (find-the-minimum-area-to-cover-all-ones-i)
// Submission ID: 1389683392
// Language: java
// Timestamp (UTC): 2024-09-14T10:33:46Z

class Solution {
    public int minimumArea(int[][] grid) {
        int topX = Integer.MAX_VALUE, bottomX = 0, leftY = Integer.MAX_VALUE, rightY = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    topX = Math.min(topX, i);
                    bottomX = i;
                    leftY = Math.min(leftY, j);
                    rightY = Math.max(rightY, j);
                }
            }
        }
        return  (1 + bottomX - topX) *  (1 + rightY - leftY);
    }
}