// LeetCode: Remove K Digits (remove-k-digits)
// Submission ID: 1649930408
// Language: java
// Timestamp (UTC): 2025-05-31T17:04:23Z

class Solution {
    public String removeKdigits(String num, int k) {
        
        if(k == num.length())return "0";
        
        Stack<Integer>st = new Stack<>();
        
        for(int i = 0; i<num.length(); i++){
            int currNum = num.charAt(i)-'0';
            
            while(k!=0 && st.size()!=0 && st.peek()>currNum){
                st.pop();
                k--;
            }
            
            
            st.push(currNum);
        }
        
        while(k>0){
            st.pop();
            k--;
        }
        
       
        
        StringBuilder rem = new StringBuilder();
        
        while(st.size()!=0){
            rem.append(st.pop());
        }
        
        rem.reverse();
        
while(rem.length()>0 && rem.charAt(0) == '0'){
    rem.deleteCharAt(0);
}   
       
       return rem.toString().length() == 0 ? "0" : rem.toString();
    }
}