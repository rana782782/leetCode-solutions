// LeetCode: 1-bit and 2-bit Characters (1-bit-and-2-bit-characters)
// Submission ID: 1652077124
// Language: java
// Timestamp (UTC): 2025-06-02T20:03:29Z

class Solution {
   public boolean isOneBitCharacter(int[] bits) {
        int i = 0;
        while (i < bits.length - 1) {
            if (bits[i] == 1) {
                i += 2;
            } else {
                i += 1;
            }
        }
        return i == bits.length - 1;
    }
}