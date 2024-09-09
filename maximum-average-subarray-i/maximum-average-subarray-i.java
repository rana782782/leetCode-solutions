// LeetCode: Maximum Average Subarray I (maximum-average-subarray-i)
// Submission ID: 1384017318
// Language: java
// Timestamp (UTC): 2024-09-09T07:52:46Z

class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double output = 0;

        int left = 0;
        int right = k-1;

        for(int i = left; i<=right; i++){
            output+=nums[i];
        }

        double maxi = output/k;

        while(right<nums.length-1){
            right++;
            int aquire = nums[right];
            int release = nums[left];
            left++;
            output = output+aquire-release;
            maxi = Math.max(maxi,output/k);
        }

        return maxi;
    }
}