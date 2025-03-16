// LeetCode: Champagne Tower (champagne-tower)
// Submission ID: 1575518572
// Language: java
// Timestamp (UTC): 2025-03-16T09:50:24Z

class Solution {
    public static class Pair {
        double exc;  // Excess champagne to be distributed
        double amt;  // Amount of champagne in the current glass

        Pair(double exc, double amt) {
            this.exc = exc;
            this.amt = amt;
        }
    }

    public static double champagneTower(int poured, int query_row, int query_glass) {
        Pair arr[][] = new Pair[101][101];

        // Initialize all cells with Pair objects
        for (int i = 0; i < 101; i++) {
            for (int j = 0; j <= i; j++) {
                arr[i][j] = new Pair(0, 0);
            }
        }

        // Pour champagne in the first glass
        arr[0][0].exc = poured;

        for (int i = 0; i <= query_row; i++) {
            for (int j = 0; j <= i; j++) {

                double excessAmt = arr[i][j].exc;

                // If the current glass overflows
                if (excessAmt > 1) {
                    arr[i][j].amt = 1.00;
                    double restAmt = (excessAmt - 1.00) / 2;

                    // Pass the excess to the next row
                    if (i + 1 < 101) {
                        arr[i + 1][j].exc += restAmt;
                        arr[i + 1][j + 1].exc += restAmt;
                    }
                } else {
                    // No overflow, all goes to amt
                    arr[i][j].amt = excessAmt;
                }
            }
        }

        // Return the amount in the requested glass
        return arr[query_row][query_glass].amt;
    }
}