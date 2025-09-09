// LeetCode: Backspace String Compare (backspace-string-compare)
// Submission ID: 1764819802
// Language: java
// Timestamp (UTC): 2025-09-09T10:43:53Z

class Solution {
    public static String getStr(String str){
        
        StringBuilder output = new StringBuilder();
        Stack<Character>st = new Stack<>();

        for(char ch : str.toCharArray()){
            if(ch=='#'){
                if(st.size()!=0)st.pop();
            }
            else{
                st.push(ch);
            }
        }


        while(!st.isEmpty()){
            output.append(st.pop());
        }
        System.out.println(output.reverse().toString());
        return output.reverse().toString();
          
        
    }
    public boolean backspaceCompare(String s, String t) {
        if(getStr(s).equals(getStr(t)))return true;

        return false;
    }
}