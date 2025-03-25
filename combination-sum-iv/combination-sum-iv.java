// LeetCode: Combination Sum IV (combination-sum-iv)
// Submission ID: 1585876518
// Language: java
// Timestamp (UTC): 2025-03-25T16:55:56Z

class Solution {
    static int memo[];
    public static int solution(int nums[], int target, int currSum){
        if(currSum>target) return 0;
        if(currSum == target) return 1;

        if(memo[currSum]!=-1) return memo[currSum];

        int ans = 0;

        for(int i = 0; i<nums.length; i++){
            ans+=solution(nums,target,currSum+nums[i]);
        }

        return memo[currSum] = ans;
    }
    public int combinationSum4(int[] nums, int target) {
        memo = new int[target+1];
        Arrays.fill(memo,-1);

        return solution(nums,target,0);
    }
}