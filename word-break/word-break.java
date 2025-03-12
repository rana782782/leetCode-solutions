// LeetCode: Word Break (word-break)
// Submission ID: 1571188660
// Language: java
// Timestamp (UTC): 2025-03-12T08:40:45Z

class Solution {
    static Boolean memo[];
    public static boolean solve(String s,int idx,List<String> wordDict) {
		if(idx>=s.length() || wordDict.contains(s)) return true;
		
		
		if(memo[idx]!=null) return memo[idx];
		
		for(int i = idx+1; i<=s.length(); i++) {
			String first = s.substring(idx, i);
			
			if(wordDict.contains(first)&& solve(s, i, wordDict)) {
				return true;
			}
			
			
		}
		
		return memo[idx] = false;
		
		
	}
    public boolean wordBreak(String s, List<String> wordDict) {
        memo = new Boolean[s.length()+1];

     return solve(s,0,wordDict);
    }
}