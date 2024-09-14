// LeetCode: Minimum Average of Smallest and Largest Elements (minimum-average-of-smallest-and-largest-elements)
// Submission ID: 1389651102
// Language: java
// Timestamp (UTC): 2024-09-14T09:53:24Z

class Solution {
    public double minimumAverage(int[] nums) {
        Arrays.sort(nums);
        int right = nums.length-1;
         int left = 0;
         double ans = Integer.MAX_VALUE;
         while(left<right){
            double avg = (nums[right]+nums[left])/2.0;
           
            ans = Math.min(ans,avg);
            left++;
            right--;
         }
         return ans;
    }
}