// LeetCode: Palindrome Partitioning II (palindrome-partitioning-ii)
// Submission ID: 1718799571
// Language: java
// Timestamp (UTC): 2025-07-31T19:51:39Z

class Solution {
    public static boolean isPal(String str){
             int start = 0;
              int end = str.length()-1;

              while(start<end){
                if(str.charAt(start)!=str.charAt(end))return false;
                start++;
                end--;
              }

              return true;
    }

static int dp[];
    public static int solution(int idx, String s){
        if(idx == s.length())return 0;
        if(dp[idx]!=-1)return dp[idx];

        int output = Integer.MAX_VALUE;
        for(int i = idx; i<s.length(); i++){
            String str = s.substring(idx,i+1);
            if(isPal(str)){
               output = Math.min(output,1+solution(i+1,s));
            }
        }

        return dp[idx] = output;
    }
    public int minCut(String s) {
        dp = new int[s.length()+1];
        Arrays.fill(dp,-1);
        return solution(0,s)-1;
    }
}