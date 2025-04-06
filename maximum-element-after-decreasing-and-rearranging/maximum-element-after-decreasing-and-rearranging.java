// LeetCode: Maximum Element After Decreasing and Rearranging (maximum-element-after-decreasing-and-rearranging)
// Submission ID: 1598841948
// Language: java
// Timestamp (UTC): 2025-04-06T18:51:04Z

class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);

        if(arr[0]!=1)arr[0] = 1;

        int maxi = 1;

        for(int i = 1; i<arr.length; i++){
            if(arr[i]-arr[i-1]>1){
                arr[i] = arr[i-1]+1;
            }
            maxi = Math.max(arr[i],maxi);
        }

        return maxi;
    }
}