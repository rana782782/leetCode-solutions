// LeetCode: Minimum Cost to Cut a Stick (minimum-cost-to-cut-a-stick)
// Submission ID: 1569712155
// Language: java
// Timestamp (UTC): 2025-03-11T01:15:58Z

class Solution {
    static int memo[][];
   public static int solve(int l, int r, int cuts[]) {
		if(r-l<=1) return 0;

        if(memo[l][r]!=-1) return memo[l][r];
		
		int minScore = Integer.MAX_VALUE;
		
		for(int i = l+1; i<=r-1; i++) {
			int score = cuts[r]-cuts[l];
			
			minScore = Math.min(minScore,score+solve(l, i, cuts)+solve(i, r, cuts));
		}
		
		return memo[l][r] = minScore;
	}
	
	 public int minCost(int n, int[] cuts) {
          memo = new int[cuts.length+2][cuts.length+2];
          for(int i = 0; i<memo.length; i++){
            Arrays.fill(memo[i],-1);
          }
	        Arrays.sort(cuts);
	        
	        int nayaArr[] = new int[cuts.length+2];
	        nayaArr[0] = 0;
	        nayaArr[nayaArr.length-1] = n;
	        
	        for(int i = 1; i<nayaArr.length-1; i++) {
	        	nayaArr[i] = cuts[i-1];
	        }
	        
	        return solve(0,nayaArr.length-1,nayaArr);
	    }
}