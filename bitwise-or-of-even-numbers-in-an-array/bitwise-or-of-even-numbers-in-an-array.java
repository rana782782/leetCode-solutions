// LeetCode: Bitwise OR of Even Numbers in an Array (bitwise-or-of-even-numbers-in-an-array)
// Submission ID: 1778053243
// Language: java
// Timestamp (UTC): 2025-09-21T12:34:41Z

class Solution {
    public int evenNumberBitwiseORs(int[] nums) {
        int output = 0;

        for(int ele : nums){
            if(ele%2 == 0){
                output|=ele;
            }
        }

        return output;
    }
}