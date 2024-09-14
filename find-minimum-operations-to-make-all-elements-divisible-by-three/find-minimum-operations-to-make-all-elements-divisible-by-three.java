// LeetCode: Find Minimum Operations to Make All Elements Divisible by Three (find-minimum-operations-to-make-all-elements-divisible-by-three)
// Submission ID: 1389689502
// Language: java
// Timestamp (UTC): 2024-09-14T10:41:37Z

class Solution {
    public int minimumOperations(int[] nums) {
        int ans= 0;
        for(int i : nums){
           if(i%3!=0){
            ans+=Math.min(i%3,3-(i%3));
           }
        }
        return ans;
    }
}