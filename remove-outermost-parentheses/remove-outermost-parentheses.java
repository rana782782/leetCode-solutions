// LeetCode: Remove Outermost Parentheses (remove-outermost-parentheses)
// Submission ID: 1486485629
// Language: java
// Timestamp (UTC): 2024-12-23T17:16:46Z

class Solution {
   	 public String removeOuterParentheses(String s) {
		 
		 if(s.length() == 1) {
			 return "";
		 }
	        StringBuilder output = new StringBuilder();
	        int lowerB = 0;
	         int upperB = 0;
	         
	         int i = 0;
	          int j = 0;
	          
	          while(i<=j && j<s.length()) {
	        	  char ch = s.charAt(j);
	        	  if(ch == '(') {
	        		  lowerB++;
	        	  }
	        	  
	        	  else {
	        		  upperB++;
	        	  }
	        	  
	        	  if(lowerB == upperB) {
	        		  String subAns = s.substring(i+1, j);
	        		  output.append(subAns);
	        		  i = j+1;
	        	  }
	        	  j++;
	          }
	          
	          return output.toString();
	    }
}