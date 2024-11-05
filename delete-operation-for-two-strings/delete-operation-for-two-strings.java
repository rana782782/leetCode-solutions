// LeetCode: Delete Operation for Two Strings (delete-operation-for-two-strings)
// Submission ID: 1443562954
// Language: java
// Timestamp (UTC): 2024-11-05T07:03:28Z

class Solution {
    public int minDistance(String word1, String word2) {
        int dp[][] = new int[word1.length()+1][word2.length()+1];

        for(int i = dp.length-1; i>=0; i--){
            for(int j = dp[0].length-1; j>=0; j--){
                if(i == dp.length-1 && j == dp[0].length-1){
                    dp[i][j] = 0;
                }

                else if(i == dp.length-1){
                    dp[i][j] = dp[i][j+1]+1;
                }

                else if(j == dp[0].length-1){
                    dp[i][j] = dp[i+1][j]+1;
                }

                else{
                    char cr = word1.charAt(i);
                    char cc = word2.charAt(j);

                    if(cr == cc){
                        dp[i][j] = dp[i+1][j+1];
                    }
                    else{
                        dp[i][j] = Math.min(dp[i+1][j],dp[i][j+1])+1;
                    }
                }
            }
        }

        return dp[0][0];
    }
}