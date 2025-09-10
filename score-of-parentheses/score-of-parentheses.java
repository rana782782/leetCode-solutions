// LeetCode: Score of Parentheses (score-of-parentheses)
// Submission ID: 1765951681
// Language: java
// Timestamp (UTC): 2025-09-10T11:10:40Z

class Solution {
      public int scoreOfParentheses(String s) {
	        Stack<Integer> st = new Stack<>();
	        
	        for(int i = 0; i<s.length(); i++) {
	        	char ch = s.charAt(i);
	        	if(ch == '(') {
	        		st.push(-1);
	        	}
	        	
	        	else {
	        		if(st.peek() == -1) {
	        			st.pop();
	        			st.push(1);
	        		}
	        		else {
	        			int sum = 0;
	        			
	        			while(st.size()!=0 && st.peek()!=-1) {
	        				sum+=st.pop();
	        			}
	        			st.pop();
	        			st.push(sum*2);
	        		}
	        	}
	        }
	        
	       int score = 0;
	       while(st.size()!=0) {
	    	   score+=st.pop();
	       }
	       
	       return score;
	    }
}