// LeetCode: Jump Game (jump-game)
// Submission ID: 1689676994
// Language: java
// Timestamp (UTC): 2025-07-07T14:53:40Z

class Solution {
    static Boolean dp[];
    public static boolean solution(int idx, int nums[]){
        if(idx >= nums.length-1)return true;
        
        if(dp[idx] != null)return dp[idx];
       for(int jump = 1; jump<=nums[idx]; jump++){
           if(solution(idx+jump,nums))return dp[idx] = true;
       }
        
        return dp[idx] = false;
        
        
    }
    public boolean canJump(int[] nums) {
        
        dp = new Boolean[nums.length];
        return solution(0,nums);
    }
}