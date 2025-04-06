// LeetCode: Remove Colored Pieces if Both Neighbors are the Same Color (remove-colored-pieces-if-both-neighbors-are-the-same-color)
// Submission ID: 1598716806
// Language: java
// Timestamp (UTC): 2025-04-06T16:44:16Z

class Solution {
    public boolean winnerOfGame(String colors) {
         if (colors.length() < 3)
            return false;
        int a = 0, b = 0;
        for (int i = 1; i < colors.length() - 1; i++) {
            char x = colors.charAt(i - 1);
            char y = colors.charAt(i);
            char z = colors.charAt(i + 1);

            if (y == 'A' && x + y + z == 195)
                a++;
            if (y == 'B' && x + y + z == 198)
                b++;
        }
        return a > b;
    }
}