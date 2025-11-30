class Solution {
    public int countElements(int[] nums, int k) {
        int n = nums.length;

        if(k == 0)return n;
        Arrays.sort(nums);

        int req = nums[n-k];

        int output = 0;

        for(int ele : nums){
            if(ele<req)output++;
            else break;
        }

        return output;
    }
}