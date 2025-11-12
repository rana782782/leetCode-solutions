class Solution {
    public static int solution(int nums[],int cmp){
                int n = nums.length;

                for(int i = 0; i<nums.length; i++){
                    if(nums[i]>=cmp)return n-i;
                }

                return -1;
    }
    public int specialArray(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        int i = 0;
        while(i<=n){
            int count = solution(nums,i);
            if(count == i)return i;
            i++;
        }

        return -1;
    }
}