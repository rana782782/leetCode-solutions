// LeetCode: Divide Array Into Equal Pairs (divide-array-into-equal-pairs)
// Submission ID: 1576535673
// Language: java
// Timestamp (UTC): 2025-03-17T08:09:45Z

class Solution {
    public boolean divideArray(int[] nums) {
         HashMap<Integer,Integer> map =new HashMap<>();
	        for(int i =0; i<nums.length; i++) {
	        	if(map.containsKey(nums[i])) {
	        		map.put(nums[i],map.get(nums[i])+1);
	        	}
	        	else {
	        		map.put(nums[i],1);
	        	}
	        }
	        
	        for(int i =0; i<nums.length; i++) {
	        	if(map.get(nums[i])%2!=0) {
	        		return false;
	        	}
	        }
	        return true;
	        
    }
}