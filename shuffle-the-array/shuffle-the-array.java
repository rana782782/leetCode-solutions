// LeetCode: Shuffle the Array (shuffle-the-array)
// Submission ID: 1653702973
// Language: java
// Timestamp (UTC): 2025-06-04T12:35:33Z

class Solution {
    public int[] shuffle(int[] nums, int n) {
        int output[] = new int[2*n];
        
        int itr1 = 0;
        int itr2 = n;
        
        for(int i = 0; i<nums.length-1; i+=2){
            output[i] = nums[itr1];
            output[i+1] = nums[itr2];
            itr1++;
            itr2++;
        }
        
        return output;
    }
}