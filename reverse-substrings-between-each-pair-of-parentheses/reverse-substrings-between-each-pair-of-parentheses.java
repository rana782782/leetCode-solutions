// LeetCode: Reverse Substrings Between Each Pair of Parentheses (reverse-substrings-between-each-pair-of-parentheses)
// Submission ID: 1486852351
// Language: java
// Timestamp (UTC): 2024-12-24T05:12:13Z

class Solution {
  public String reverseParentheses(String s) {
	        Stack<Character> st = new Stack<>();
	        for(int i = 0; i<s.length(); i++) {
	        	char ch = s.charAt(i);
	        	
	        	if(ch == ')') {
	        	
	        			Queue<Character> q = new LinkedList<>();
	        			
	        			while(st.size()!=0 && st.peek()!='(') {
	        				q.add(st.pop());
	        			}
	        			st.pop();
	        			
	        			while(q.size()!=0) {
	        				st.push(q.poll());
	        			}
	        		
	        	}
	        	
	        	else {
	        		st.push(ch);
	        	}
	        }
	        
	        StringBuilder output = new StringBuilder();
	        
	        while(st.size()!=0) {
	        	output.append(st.pop());
	        }
	        output.reverse();
	        
	        return output.toString();
	    }
}