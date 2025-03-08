// LeetCode: Minimum Recolors to Get K Consecutive Black Blocks (minimum-recolors-to-get-k-consecutive-black-blocks)
// Submission ID: 1566696099
// Language: java
// Timestamp (UTC): 2025-03-08T06:19:30Z

class Solution {
      public static int minimumRecolors(String blocks, int k) {
	        StringBuilder target = new StringBuilder();
	        for(int i = 0; i<k; i++) {
	        	target.append("B");
	        }
	        
	        if(blocks.contains(target)) return 0;
	        
	        int white = 0;
	         int black = 0 ;
	         
	         
	         for(int i =0; i<k; i++) {
	        	 char ch = blocks.charAt(i);
	        	 if(ch == 'W')white++;
	        	 else {
	        		 black++;
	        	 }
	         }
	         int minRecolor = white;
	         
	         int right = k-1;
	         int left = 0;
	         
	         while(right<blocks.length()-1) {
	        	 right++;
	        	 char ch = blocks.charAt(right);
	        	 
	        	 if(ch == 'B')black++;
	        	 else {
	        		 white++;
	        	 }
	        	 
	        	 char chLeft = blocks.charAt(left);
	        	 if(chLeft=='B')black--;
	        	 else {
	        		 white--;
	        	 }
	        	 left++;
	        	 minRecolor = Math.min(white, minRecolor);
	         }
	         
	         return minRecolor;
	    }
}