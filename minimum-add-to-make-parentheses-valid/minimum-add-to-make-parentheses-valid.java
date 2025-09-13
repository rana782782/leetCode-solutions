// LeetCode: Minimum Add to Make Parentheses Valid (minimum-add-to-make-parentheses-valid)
// Submission ID: 1769055582
// Language: java
// Timestamp (UTC): 2025-09-13T08:22:50Z

class Solution {
   
	  public int minAddToMakeValid(String s) {
	        Stack<Character> st = new Stack<>();
	        int counter = 0;
	        
	      for(int i = 0; i<s.length(); i++) {
	    	  char ch = s.charAt(i);
	    	  
	    	  if(ch == '(') {
	    		  st.push('(');
	    	  }
	    	  
	    	  else if(st.size()!=0 && st.peek() == '(') {
	    			 st.pop();
	    			 
	    	  }
	    	  else {
	    		  counter++;
	    	  }
	      }
	      
	     return st.size()+counter;
	    }
}