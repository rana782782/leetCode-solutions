// LeetCode: Validate Stack Sequences (validate-stack-sequences)
// Submission ID: 1771940265
// Language: java
// Timestamp (UTC): 2025-09-15T18:20:43Z

class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> st = new Stack<>();
        int j = 0;
        
        for(int i = 0; i<pushed.length; i++) {
        	st.push(pushed[i]);
        	
        	while( st.size()!=0 && st.peek() == popped[j]) {
        		st.pop();
        		j++;
        	}
        }
        
        return st.isEmpty();
    }
}