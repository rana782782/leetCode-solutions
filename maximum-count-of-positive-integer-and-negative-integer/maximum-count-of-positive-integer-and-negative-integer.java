// LeetCode: Maximum Count of Positive Integer and Negative Integer (maximum-count-of-positive-integer-and-negative-integer)
// Submission ID: 1570878708
// Language: java
// Timestamp (UTC): 2025-03-12T02:41:09Z

class Solution {
    public int maximumCount(int[] nums) {
        int positiveNum = 0;
        int negativeNum = 0;

        for(int i = 0; i<nums.length; i++){
            int ele = nums[i];

            if(ele<0)negativeNum++;

            else if(ele>0)positiveNum++;
        }
       return  Math.max(negativeNum,positiveNum);
    }
}