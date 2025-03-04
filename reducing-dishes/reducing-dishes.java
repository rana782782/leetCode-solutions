// LeetCode: Reducing Dishes (reducing-dishes)
// Submission ID: 1562541817
// Language: java
// Timestamp (UTC): 2025-03-04T12:19:13Z

class Solution {
        static int memo[][];

    	public static int solution(int satisfaction[], int idx, int timeUnit) {
		if(idx>=satisfaction.length)return 0;

        if(memo[idx][timeUnit]!=-1) return memo[idx][timeUnit];
		
		int inc = (timeUnit*satisfaction[idx])+solution(satisfaction, idx+1, timeUnit+1);
		int exc = solution(satisfaction, idx+1, timeUnit);
		
		
		return memo[idx][timeUnit] = Math.max(inc, exc);
	}
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int n = satisfaction.length;
        memo = new int[n+1][n+1];

        for(int i = 0; i<n; i++){
            Arrays.fill(memo[i],-1);
        }

        return solution(satisfaction,0,1);
    }
}