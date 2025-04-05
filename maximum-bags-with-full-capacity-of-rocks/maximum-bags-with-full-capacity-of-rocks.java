// LeetCode: Maximum Bags With Full Capacity of Rocks (maximum-bags-with-full-capacity-of-rocks)
// Submission ID: 1597444463
// Language: java
// Timestamp (UTC): 2025-04-05T12:27:15Z

class Solution {
  	  public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
	        int ans = 0;
	        
	        List<Integer>diffList = new ArrayList<>();
	        
	        for(int i = 0; i<capacity.length; i++) {
	        	int diff = capacity[i]-rocks[i];
	        	
	        	if(diff == 0)ans++;
	        	else {
	        		diffList.add(diff);
	        	}
	        }
	        
	        Collections.sort(diffList);
	        
	       for(int ele : diffList) {
	    	   if(additionalRocks == 0)break;
	    	   if(additionalRocks-ele>=0) {
	    		   additionalRocks-=ele;
	    		   ans++;
	    	   }
	       }
	       
	       return ans;
	    }
}