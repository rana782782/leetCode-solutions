// LeetCode: Sum of Digits in the Minimum Number (sum-of-digits-in-the-minimum-number)
// Submission ID: 1781175859
// Language: java
// Timestamp (UTC): 2025-09-24T11:21:52Z

class Solution {
    public static int findMin(int arr[]){
        int output = Integer.MAX_VALUE;

        for(int ele : arr){
            output = Math.min(output,ele);
        }

        return output;
    }

    public static int getDigitSum(int ele){
        int output = 0;
        while(ele!=0){
            int rem = ele%10;
            output+=rem;
            ele/=10;
        }

        return output;
    }
    public int sumOfDigits(int[] nums) {
        int minNum = findMin(nums);
        int digitSum = getDigitSum(minNum);

        return digitSum%2 == 1 ? 0 : 1;
    }
}