// LeetCode: Divide Array Into Arrays With Max Difference (divide-array-into-arrays-with-max-difference)
// Submission ID: 1585622891
// Language: java
// Timestamp (UTC): 2025-03-25T13:07:11Z

class Solution {
    public int[][] divideArray(int[] nums, int k) {
        int n= nums.length;
        int output[][] = new int[n/3][3];

        Arrays.sort(nums);

        for(int i= 0; i<nums.length; i+=3){

            if(nums[i+2]-nums[i]<=k){
                output[i/3][0] = nums[i];
                output[i/3][1] = nums[i+1];
                output[i/3][2] = nums[i+2];
            }
            else{
                return new int[0][0];
            }
        }

        return output;
    }
}