// LeetCode: Smallest Range I (smallest-range-i)
// Submission ID: 1768141079
// Language: java
// Timestamp (UTC): 2025-09-12T10:15:35Z

class Solution {
    public int smallestRangeI(int[] nums, int k) {
        int min = Integer.MAX_VALUE;
        int max = 0;

        for(int ele : nums){
            min = Math.min(ele,min);
            max = Math.max(ele,max);
        }

        int diff = max-min;
        if(diff<=2*k)return 0;

        return diff-(2*k);
    }
}