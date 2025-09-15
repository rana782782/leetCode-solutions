// LeetCode: Bag of Tokens (bag-of-tokens)
// Submission ID: 1771956544
// Language: java
// Timestamp (UTC): 2025-09-15T18:34:42Z

class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        int maxScore = 0;
        int i = 0;
         int j = tokens.length-1;
         int score = 0;
         Arrays.sort(tokens);


         while(i<=j){

            if(power>=tokens[i]){
                power-=tokens[i];
                score+=1;
                maxScore = Math.max(maxScore,score);
                i++;
            }

            else if(score>=1){
                score-=1;
                power+=tokens[j];
                j--;
            }

            else{
                return maxScore;
            }
         }

         return maxScore;
    }
}