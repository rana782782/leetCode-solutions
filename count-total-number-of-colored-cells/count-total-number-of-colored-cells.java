// LeetCode: Count Total Number of Colored Cells (count-total-number-of-colored-cells)
// Submission ID: 1563283704
// Language: java
// Timestamp (UTC): 2025-03-05T04:23:50Z

class Solution {
   public long coloredCells(int n) {
    long totalCells = (2L * n - 1) * (2L * n - 1);
    long emptyCells = 4L * ((long)(n - 1) * n) / 2;
    return totalCells - emptyCells;
}

}