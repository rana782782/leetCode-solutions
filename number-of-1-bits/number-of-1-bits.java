// LeetCode: Number of 1 Bits (number-of-1-bits)
// Submission ID: 1649995942
// Language: java
// Timestamp (UTC): 2025-05-31T18:20:27Z

class Solution {
    public int hammingWeight(int n) {
        
        int count = 0;
        
        while(n!=0){
            if(n%2 == 1)count++;
            
            n/=2;
        }
        
        return count;
    }
}