// LeetCode: Check if There is a Valid Partition For The Array (check-if-there-is-a-valid-partition-for-the-array)
// Submission ID: 1571300349
// Language: java
// Timestamp (UTC): 2025-03-12T11:00:48Z

class Solution {
    static Boolean memo[];
    public static boolean solution(int idx, int nums[]) {
		if(idx>=nums.length) return true;
        if(memo[idx]!=null) return memo[idx];
		
		for(int i = 2; i<=3; i++) {
			if(i == 2 && idx+2<=nums.length) {
				
				if((nums[idx] == nums[idx+1]) && solution(idx+2, nums)) return true;
			}
			
			else if(i == 3 && idx+3<=nums.length) {
				
				if((nums[idx]+1 == nums[idx+1] && nums[idx+1]+1 == nums[idx+2]) && solution(idx+3, nums))return true;
				
				else if((nums[idx] == nums[idx+1] && nums[idx+1] == nums[idx+2]) && solution(idx+3, nums))return true;
			}
		}
		
		return memo[idx] = false;
	}
    public boolean validPartition(int[] nums) {
        memo = new Boolean[nums.length+1];
        return solution(0,nums);
    }
}