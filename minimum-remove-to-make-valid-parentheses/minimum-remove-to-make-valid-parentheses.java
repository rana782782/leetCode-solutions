// LeetCode: Minimum Remove to Make Valid Parentheses (minimum-remove-to-make-valid-parentheses)
// Submission ID: 1730220384
// Language: java
// Timestamp (UTC): 2025-08-10T14:42:52Z

class Solution {
    public String minRemoveToMakeValid(String s) {
        int n = s.length();
         boolean arr[] = new boolean[n];
         Arrays.fill(arr,true);
        Stack<Integer>st = new Stack<>();


    for(int i = 0; i<n; i++){
        char ch = s.charAt(i);
        if(ch == '('){
            st.push(i);
        }
      else if(ch == ')'){
        if(st.size()!=0)st.pop();
        else{
            arr[i] = false;
        }
      }
    }

    while(st.size()!=0){
        arr[st.pop()] = false;
    }

    StringBuilder output = new StringBuilder();
    for(int i = 0; i<n; i++){
        if(arr[i]){
            output.append(s.charAt(i));
        }
    }

    return output.toString();
}
}