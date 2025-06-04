// LeetCode: Hamming Distance (hamming-distance)
// Submission ID: 1653698029
// Language: java
// Timestamp (UTC): 2025-06-04T12:28:45Z

class Solution {
  public int hammingDistance(int x, int y) {
        int xor = x ^ y;
        int count = 0;
        
        while (xor != 0) {
            count += xor & 1; 
            xor >>= 1;        
        }
        
        return count;
    }
}