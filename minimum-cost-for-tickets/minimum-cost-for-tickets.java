// LeetCode: Minimum Cost For Tickets (minimum-cost-for-tickets)
// Submission ID: 1562520603
// Language: java
// Timestamp (UTC): 2025-03-04T11:46:34Z

class Solution {
    	static int memo[][];
	public static int solution(int days[],int costs[], int idx,int freeDays) {
		if(idx>=days.length) return 0;
		
		int oneDay = Integer.MAX_VALUE;
		int sevenDay = Integer.MAX_VALUE;
		int thirtyDay = Integer.MAX_VALUE;
		int noPass = Integer.MAX_VALUE;
		
		if(memo[idx][freeDays]!=-1) return memo[idx][freeDays];
			
		
		
		if(days[idx]>freeDays) {
			oneDay = costs[0]+solution(days, costs, idx+1, days[idx]);
			
			sevenDay = costs[1]+solution(days, costs, idx+1, days[idx]+6);
			thirtyDay = costs[2]+solution(days, costs, idx, days[idx]+29);
		}
		
		else {
			noPass = solution(days, costs, idx+1, freeDays);
		}
		
		
		return memo[idx][freeDays]= Math.min(Math.min(oneDay, sevenDay),Math.min(thirtyDay, noPass));
		
	}
    public int mincostTickets(int[] days, int[] costs) {
        memo = new int[366][396];

        for(int i =0; i<memo.length; i++){
            Arrays.fill(memo[i],-1);
        }

        return solution(days,costs,0,0);
    }
}