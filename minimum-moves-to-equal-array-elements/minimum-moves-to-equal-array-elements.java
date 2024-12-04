// LeetCode: Minimum Moves to Equal Array Elements (minimum-moves-to-equal-array-elements)
// Submission ID: 1469942567
// Language: java
// Timestamp (UTC): 2024-12-04T07:18:57Z

class Solution {
    public int minMoves(int[] nums) {
        
        int smallest = Integer.MAX_VALUE;
	        int sum =  0;
	        int len = nums.length;
	        
	        for(int i = 0; i<nums.length; i++) {
	        	sum+=nums[i];
	        	smallest = Math.min(smallest, nums[i]);
	        }
	        
	        int output = sum-(smallest*len);
	        return output;
    }
}