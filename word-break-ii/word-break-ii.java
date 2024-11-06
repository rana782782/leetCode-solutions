// LeetCode: Word Break II (word-break-ii)
// Submission ID: 1444702720
// Language: java
// Timestamp (UTC): 2024-11-06T10:44:19Z

class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> dp[] = new ArrayList[s.length()];
    
    for(int i = 0; i<dp.length; i++){
        dp[i] = new ArrayList<>();
    }
        for(int i = 0; i<dp.length; i++){
            for(int j = 0; j<=i; j++){
                String word = s.substring(j,i+1);
                if(wordDict.contains(word)){
                    if(j>0){
                      List<String> subAns = dp[j-1];
                      for(String str : subAns){
                        dp[i].add(str+" "+word);
                      }
                    }
                    else{
                        dp[i].add(word);
                    }
                }
            }
        }

        return dp[s.length()-1];
    }
}