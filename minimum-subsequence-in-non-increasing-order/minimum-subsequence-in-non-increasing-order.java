// LeetCode: Minimum Subsequence in Non-Increasing Order (minimum-subsequence-in-non-increasing-order)
// Submission ID: 1388545969
// Language: java
// Timestamp (UTC): 2024-09-13T07:57:16Z

class Solution {
    public List<Integer> minSubsequence(int[] nums) {
        Arrays.sort(nums);
        List<Integer> output = new ArrayList<>();

        int sum = 0;
        for(int i = 0; i<nums.length; i++){
            sum+=nums[i];
        }
  int backSum = 0;
        for(int i = nums.length-1; i>=0; i--){
          backSum+=nums[i];
          output.add(nums[i]);
          if(sum-backSum<backSum){
            break;
          }
        }

        return output;
    }
}