class Solution {
    public int minIncrementForUnique(int[] nums) {
        int count = 0;

        Arrays.sort(nums);

        

        for(int i = 1; i<nums.length; i++){
            int prev = nums[i-1];
            int curr = nums[i];

            if(prev==curr || prev>curr){
                int diff = prev+1-curr;
                count+=diff;
                nums[i] = prev+1;
            }
        }

        return count;


    }
}