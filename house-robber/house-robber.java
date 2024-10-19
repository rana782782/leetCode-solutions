// LeetCode: House Robber (house-robber)
// Submission ID: 1427238403
// Language: java
// Timestamp (UTC): 2024-10-19T11:38:30Z

class Solution {
    public int rob(int[] nums) {
        int oInc = nums[0];
        int oExc = 0;

        for(int i = 1; i<nums.length; i++){
            int nInc = oExc+nums[i];
            int nExc = Math.max(oInc,oExc);
            oInc = nInc;
            oExc = nExc;
        }

        return Math.max(oInc,oExc);
    }
}