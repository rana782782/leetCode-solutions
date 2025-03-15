// LeetCode: Extra Characters in a String (extra-characters-in-a-string)
// Submission ID: 1574782219
// Language: java
// Timestamp (UTC): 2025-03-15T17:56:02Z

class Solution {
    static int memo[];
     public static int solution(int idx, String str, HashSet<String> set){
	        if(idx>=str.length()) return 0;

	        int minCost = Integer.MAX_VALUE;
            if(memo[idx]!=-1) return memo[idx];
	        for(int i = idx+1; i<=str.length(); i++){
	            int ans1 = Integer.MAX_VALUE;
	            int ans2 = Integer.MAX_VALUE;

	            String first = str.substring(idx,i);

	            if(set.contains(first)){
	                ans1 = solution(i,str,set);
	            }

	            else{
	                ans2 = (i-idx)+solution(i,str,set);
	            }

	            minCost = Math.min(minCost,Math.min(ans1,ans2));
	        }

	        return memo[idx] = minCost;
	    }
    public int minExtraChar(String s, String[] dictionary) {
        HashSet<String> set = new HashSet<>();
        for(String str : dictionary){
            set.add(str);
        }
        memo = new int[s.length()+1];
        Arrays.fill(memo,-1);
        return solution(0,s,set);
    }
}