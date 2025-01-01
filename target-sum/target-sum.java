// LeetCode: Target Sum (target-sum)
// Submission ID: 1494313905
// Language: java
// Timestamp (UTC): 2025-01-01T17:27:39Z

class Solution {

    static int ans = 0;
	public static void solution(int nums[], int idx, int sum, int target) {
		
		if(idx>nums.length) {
			return;
		}
		if(idx == nums.length) {
			if(sum == target) {
				ans++;
				
			}
			return;
		}
		
		solution(nums, idx+1, sum+nums[idx],target);
		
		solution(nums,idx+1,sum-nums[idx],target);
	}
    public int findTargetSumWays(int[] nums, int target) {
        ans = 0;
        solution(nums,0,0,target);
        return ans;
    }
}