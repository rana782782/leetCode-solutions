// LeetCode: Maximum Product of Two Elements in an Array (maximum-product-of-two-elements-in-an-array)
// Submission ID: 1382407312
// Language: java
// Timestamp (UTC): 2024-09-07T18:56:14Z

class Solution {
    public int maxProduct(int[] nums) {
          PriorityQueue<Integer> pq = new PriorityQueue<>();
	        for(int i =0; i<2; i++) {
	        	pq.add(nums[i]);
	        }
	        
	        for(int i =2; i<nums.length; i++) {
	        	if(pq.peek()<nums[i]) {
	        		pq.poll();
	        		pq.add(nums[i]);
	        	}
	        }
	        int a = pq.poll()-1;
	        int b = pq.poll()-1;
	        return a*b;
    }
}