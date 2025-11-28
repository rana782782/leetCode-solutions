class Solution {
    public int[] transformArray(int[] nums) {
        
        for(int i = 0; i<nums.length; i++){
                int ele = nums[i];

                if(ele%2 == 0)nums[i] = 0;
                else nums[i] = 1;
        }

        Arrays.sort(nums);

        return nums;
    }
}