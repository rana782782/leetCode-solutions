// LeetCode: Find Subarrays With Equal Sum (find-subarrays-with-equal-sum)
// Submission ID: 1694853401
// Language: java
// Timestamp (UTC): 2025-07-12T04:32:11Z

class Solution {
    public boolean findSubarrays(int[] nums) {
        HashSet<Integer>set = new HashSet<>();

        for(int i = 0; i<nums.length-1; i++){
            int sum = nums[i]+nums[i+1];
            if(set.contains(sum))return true;
            set.add(sum);
        }

        return false;
    }
}