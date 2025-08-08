// LeetCode: Find Peak Element (find-peak-element)
// Submission ID: 1728068871
// Language: java
// Timestamp (UTC): 2025-08-08T15:13:05Z

class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        if(n == 1)return 0;
        
        int start = 0;
        int end = n-1;
        
        while(start<=end){
            
            int mid = start+(end-start)/2;
            
            if(mid-1>=0 && mid+1<n && nums[mid-1]<nums[mid] && nums[mid]>nums[mid+1])return mid;
            else if(mid+1<n && nums[mid]<nums[mid+1])start = mid+1;
            else{
                end = mid-1;
            }
        }
        
        return start;
    }
}