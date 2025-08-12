// LeetCode: Check If Word Is Valid After Substitutions (check-if-word-is-valid-after-substitutions)
// Submission ID: 1732432573
// Language: java
// Timestamp (UTC): 2025-08-12T12:47:24Z

class Solution {
    public boolean isValid(String s) {
        Stack<Character>st = new Stack<>();


        for(char ch : s.toCharArray()){
            if(ch == 'c'){
           int count = 2;
           int temp = 'b';
           while(!st.isEmpty() && count!=0 && st.peek() == temp){
                st.pop();
                count--;
                temp = 'a';
           } 
           if(count!=0)return false;
            }
                else{
                    st.push(ch);
                }
            }

            return st.size() == 0 ? true : false;
        }


    }
