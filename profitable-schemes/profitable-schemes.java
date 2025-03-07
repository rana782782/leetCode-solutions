// LeetCode: Profitable Schemes (profitable-schemes)
// Submission ID: 1565877691
// Language: java
// Timestamp (UTC): 2025-03-07T10:27:33Z

class Solution {
    static int memo[][][];
    static int MOD = 1000000007;
    public static int profitableSchemes1(int currMem, int currProfit, int idx,int maxMem, int minProfit, int[] group, int[] profit) {
	       if(currMem>maxMem) return 0;
	       
	       if(idx==group.length) {
	    	   
	    	   if(currProfit>=minProfit) return memo[currMem][currProfit][idx] = 1;
	    	   else {
	    		   return memo[currMem][currProfit][idx] = 0;
	    	   }
	       }
	       if(memo[currMem][currProfit][idx]!=-1) return memo[currMem][currProfit][idx];
	       int did = profitableSchemes1(currMem+group[idx],Math.min(currProfit+profit[idx],minProfit), idx+1, maxMem, minProfit, group, profit)%MOD;
	       int not_did = profitableSchemes1(currMem, currProfit, idx+1, maxMem, minProfit, group, profit)%MOD;
	        
	      return memo[currMem][currProfit][idx] = (did+not_did)%MOD;
	    }
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        memo = new int[101][101][101];
        for(int i = 0; i<101; i++){
            for(int j = 0; j<101; j++){
                Arrays.fill(memo[i][j],-1);
            }
        }
        return profitableSchemes1(0,0,0,n,minProfit,group,profit);
    }
}