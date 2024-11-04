// LeetCode: Minimum Insertion Steps to Make a String Palindrome (minimum-insertion-steps-to-make-a-string-palindrome)
// Submission ID: 1442719551
// Language: java
// Timestamp (UTC): 2024-11-04T12:31:03Z

class Solution {
    public static int lps(String s){
        int dp[][] = new int[s.length()][s.length()];

        for(int gap = 0; gap<s.length(); gap++){
            for(int i = 0, j=gap; j<dp[0].length; i++,j++){
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
                        dp[i][j] = 2+dp[i+1][j-1];
                    }

                    else{
                        dp[i][j] = Math.max(dp[i][j-1],dp[i+1][j]);
                    }
                }
            }
        }

        return dp[0][s.length()-1];
    }
    public int minInsertions(String s) {

        int ans = s.length()-lps(s);

        return ans;
        
    }
}