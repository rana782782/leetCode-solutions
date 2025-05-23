// LeetCode: Missing Number In Arithmetic Progression (missing-number-in-arithmetic-progression)
// Submission ID: 1642391159
// Language: java
// Timestamp (UTC): 2025-05-23T18:23:22Z

class Solution {
    public int missingNumber(int[] arr) {
        int n = arr.length+1;

        double orgSum = n*(arr[0]+((arr[n-2]-arr[0])/2.0));

        int currSum = 0;
        for(int ele : arr){
            currSum+=ele;
        }

        return (int)orgSum-currSum;


    }
}