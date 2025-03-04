// LeetCode: Flip String to Monotone Increasing (flip-string-to-monotone-increasing)
// Submission ID: 1562375166
// Language: java
// Timestamp (UTC): 2025-03-04T08:24:47Z

class Solution {
    static int memo[][];
    	public static int solution(String s, int idx, int prev) {
		if(idx>=s.length())return 0;
		
		int flip = Integer.MAX_VALUE;
		int no_flip = Integer.MAX_VALUE;

        if(memo[idx][prev]!=-1) return memo[idx][prev];
		
		if(s.charAt(idx)-'0' == 0) {
			if(prev == 0) {
				flip = 1+solution(s, idx+1,1);
				no_flip = solution(s, idx+1, 0);
			}
			
			else {
				flip = 1+solution(s, idx+1, 1);
			}
		}
		
		else if(s.charAt(idx)-'0' == 1){
			if(prev == 0) {
				flip = 1+solution(s, idx+1, 0);
				no_flip = solution(s, idx+1, 1);
			}
			
			else {
				no_flip = solution(s, idx+1, 1);
			}
		}
		
		return memo[idx][prev] = Math.min(flip, no_flip);
	}
    public int minFlipsMonoIncr(String s) {
       memo = new int[100001][2];
        for(int i = 0; i<memo.length; i++){
            Arrays.fill(memo[i],-1);
        }
        return solution(s,0,0);
    }
}