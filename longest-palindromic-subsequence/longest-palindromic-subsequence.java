// LeetCode: Longest Palindromic Subsequence (longest-palindromic-subsequence)
// Submission ID: 1439664384
// Language: java
// Timestamp (UTC): 2024-11-01T07:16:04Z

class Solution {
    public int longestPalindromeSubseq(String s) {
        int dp[][] =  new int[s.length()][s.length()];

        for(int gap = 0; gap<s.length(); gap++){

            for(int i = 0,j = gap; j<dp.length; i++,j++){
                if(gap == 0){
                    dp[i][j] = 1;
                }

                else if(gap == 1){
                      if(s.charAt(i) == s.charAt(j)){
                        dp[i][j] = 2;
                      }
                      else{
                        dp[i][j] = 1;
                      }
                }

                else{
                    if(s.charAt(i) == s.charAt(j)){
                        dp[i][j] = dp[i+1][j-1]+2;
                    }
                    else{
                        dp[i][j] = Math.max(dp[i][j-1],dp[i+1][j]);
                    }
                }
            }
        }

        return dp[0][s.length()-1];
    }
}