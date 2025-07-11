// LeetCode: Number of Times Binary String Is Prefix-Aligned (number-of-times-binary-string-is-prefix-aligned)
// Submission ID: 1693814569
// Language: java
// Timestamp (UTC): 2025-07-11T04:00:11Z

class Solution {
    public int numTimesAllBlue(int[] flips) {
        int max = 0;
        int count = 0;

        for (int i = 0; i < flips.length; i++) {
            max = Math.max(max, flips[i]);
            if (max == i + 1) {
                count++;
            }
        }

        return count;
    }
}
