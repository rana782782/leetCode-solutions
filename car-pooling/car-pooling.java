// LeetCode: Car Pooling (car-pooling)
// Submission ID: 1597973127
// Language: java
// Timestamp (UTC): 2025-04-06T01:57:27Z

class Solution {
   	 public boolean carPooling(int[][] trips, int capacity) {
	        if(trips.length == 1) {
	        	if(trips[0][0]>capacity)return false;
	        	
	        	return true;
	        }
	        
	        
	        Arrays.sort(trips,(a,b)->Integer.compare(a[1], b[1]));
	        
	        int endLimit = 0;
    for (int[] trip : trips) {
        endLimit = Math.max(endLimit, trip[2]);
    }
	        
	        	int pass[] = new int[endLimit+2];
	        	
	        	Arrays.fill(pass, 0);
	        	
	        	for(int i = 0; i<trips.length; i++) {
	        		int currPass = trips[i][0];
	        		int start = trips[i][1];
	        		int end = trips[i][2];
	        		
	        		pass[start]+=currPass;
	        		
	        		pass[end]-=currPass;
	        	}
	        	
	        	
	        	int prefixSum = 0;
	        	
	        	for(int i = 0; i<pass.length; i++) {
	        		prefixSum+=pass[i];
	        		if(prefixSum>capacity)return false;
	        		pass[i] = prefixSum;
	        	}
	        	
	        	return true;
	        	
	        
	        
	    }
}