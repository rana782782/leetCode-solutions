// LeetCode: Generate Parentheses (generate-parentheses)
// Submission ID: 1675230406
// Language: java
// Timestamp (UTC): 2025-06-24T18:06:02Z

class Solution {
    static List<String>output;
    public static void solution(int o, int c, String str){
        if(o>c)return;
        
        if(o<0 && c<0)return;
        if(o == 0 && c == 0){
            output.add(str);
            return;
        }
        
        if(o>0)solution(o-1,c,str+"(");
        if(c>0)solution(o,c-1,str+")");
    }
    public List<String> generateParenthesis(int n) {
        output = new ArrayList<>();
        solution(n-1,n,"(");
        return output;
    }
}