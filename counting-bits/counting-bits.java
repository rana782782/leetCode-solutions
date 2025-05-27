// LeetCode: Counting Bits (counting-bits)
// Submission ID: 1646487809
// Language: java
// Timestamp (UTC): 2025-05-27T23:34:54Z

class Solution {
	public int find(int i ){
			int count =0;
	while(i>=1) {
	        		if(i%2!=0) {
	        			count++;
	        		}
	        		i = i/2;
	        	}
						return count;
	}
    public int[] countBits(int n) {
         int ans[] = new int[n+1];
         HashMap<Integer,Integer>map = new HashMap<>();
	        
	        for(int i =0; i<=n; i++) {
	        
	          
	        	ans[i] = find(i);
	        }
	        return ans; 
    }
}