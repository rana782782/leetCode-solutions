// LeetCode: Minimum Moves to Equal Array Elements II (minimum-moves-to-equal-array-elements-ii)
// Submission ID: 1470094634
// Language: java
// Timestamp (UTC): 2024-12-04T11:31:23Z

class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int i = 0;
        int j = nums.length-1;

        int steps = 0;

        while(i<j){
            steps = steps+(nums[j]-nums[i]);
            i++;
            j--;
        }

        return steps;
    }
}