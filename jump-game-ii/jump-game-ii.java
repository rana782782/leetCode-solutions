// LeetCode: Jump Game II (jump-game-ii)
// Submission ID: 1642520999
// Language: java
// Timestamp (UTC): 2025-05-23T22:51:29Z

class Solution {
    static int memo[];
    public static int solution(int idx, int nums[]){
        if(idx >=nums.length-1)return 0;

        if(memo[idx]!=-1)return memo[idx];

        int output = Integer.MAX_VALUE;

        int steps = nums[idx];

        for(int i = 1; i<=steps; i++){
           int subAns = solution(i+idx,nums);
           if(subAns!=Integer.MAX_VALUE){
            output = Math.min(output,1+subAns);
           }
        }

        return memo[idx] = output;
    }
    public int jump(int[] nums) {
        memo = new int[nums.length];
        Arrays.fill(memo,-1);
        return solution(0,nums);
    }
}