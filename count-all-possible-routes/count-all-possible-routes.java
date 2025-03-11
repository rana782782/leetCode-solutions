// LeetCode: Count All Possible Routes (count-all-possible-routes)
// Submission ID: 1570195832
// Language: java
// Timestamp (UTC): 2025-03-11T11:48:25Z

class Solution {
    static int memo[][];
    static int MOD = 1000000007;
    public static int solution(int locations[], int start, int finish, int fuel){
        if(fuel<0) return 0;

        int remAns = (start == finish) ? 1:0;
      

        int ans = 0;
        if(memo[start][fuel]!=-1) return memo[start][fuel];

        for(int i = 0; i<locations.length; i++){
            if(i == start) continue;

            int consume = Math.abs(locations[start]-locations[i]);
            
            ans = (ans+solution(locations,i,finish,fuel-consume))%MOD;
        }

        return memo[start][fuel] = (ans+remAns)%MOD;
    }
    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        memo = new int[locations.length+1][fuel+1];

        for(int i = 0; i<memo.length; i++){
            Arrays.fill(memo[i],-1);
        }

        return solution(locations,start,finish,fuel)%MOD;
    }
}