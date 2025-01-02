// LeetCode: Construct the Rectangle (construct-the-rectangle)
// Submission ID: 1494984721
// Language: java
// Timestamp (UTC): 2025-01-02T10:30:22Z

class Solution {
     public int[] constructRectangle(int area) {
	      int output[] = new int[2];
	      
	      int width = (int)Math.sqrt(area);
	      
	      for(int i = width; i>=1; i--) {
	    	  if(area%i == 0) {
	    		  int j = area/i;
	    		  
	    		  output[0] = Math.max(width,j);
	    		  output[1] = Math.min(width, i);
	    		  break;
	    		  
	    	  }
	      }
	      
	      return output;
	        
	    }
}