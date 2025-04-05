// LeetCode: Minimum Cost to Reach Every Position (minimum-cost-to-reach-every-position)
// Submission ID: 1597924405
// Language: java
// Timestamp (UTC): 2025-04-05T23:52:50Z

class Solution {
    public int[] minCosts(int[] cost) {
        int n = cost.length;
        
        int output[] = new int[n];
        
        int mini = Integer.MAX_VALUE;
        
        for(int i = 0; i<n; i++){
            mini = Math.min(mini,cost[i]);
            
            output[i] = mini;
        }
        
        return output;
    }
}