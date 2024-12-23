// LeetCode: Next Greater Element II (next-greater-element-ii)
// Submission ID: 1486143326
// Language: java
// Timestamp (UTC): 2024-12-23T09:19:58Z

class Solution {
   	 public int[] nextGreaterElements(int[] nums) {
		 if(nums.length == 1) {
			 int ans[] = new int[1];
			 ans[0] = -1;
			 return ans;
		 }
	        Stack<Integer> st = new Stack<>();
	        int output[] = new int[nums.length];
	        
	        for(int i = nums.length-2; i>=0; i--) {
	        	while(st.size()!=0 && nums[i]>=st.peek()) {
	        		st.pop();
	        	}
	        	st.push(nums[i]);
	        }
	        
	        for(int i = nums.length-1; i>=0; i--) {
	        	while(st.size()!=0 && nums[i]>=st.peek()) {
	        		st.pop();
	        	}
	        	
	        	if(st.size() == 0) {
	        		output[i] = -1;
	        	}
	        	
	        	else {
	        		output[i] = st.peek();
	        	}
	        	
	        	st.push(nums[i]);
	        }
	        
	        return output;
	        
	    }
}