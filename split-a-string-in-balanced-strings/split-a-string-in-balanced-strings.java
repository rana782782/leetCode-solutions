// LeetCode: Split a String in Balanced Strings (split-a-string-in-balanced-strings)
// Submission ID: 1673239824
// Language: java
// Timestamp (UTC): 2025-06-23T03:57:53Z

class Solution {
    public static boolean isBalanced(String str){
        int l =0;
        int r = 0;
        
        for(int i = 0; i<str.length(); i++){
            char ch = str.charAt(i);
            if(ch == 'L')l++;
            else{
                r++;
            }
        }
        
        return l == r;
    }
    
    static int dp[];
    public static int solution(int idx,String str){
        if(idx>str.length())return 0;
        
        if(dp[idx]!=-1)return dp[idx];
        
        int output = 0;
        
        for(int len = 1; len+idx<=str.length(); len++){
            
            String substr = str.substring(idx,idx+len);
            if(isBalanced(substr)){
                output = Math.max(output,1+solution(idx+len,str));
            }
        }
        
        return dp[idx] = output;
    }
    public int balancedStringSplit(String s) {
        dp = new int[s.length()+1];
        Arrays.fill(dp,-1);
        return solution(0,s);
    }
}