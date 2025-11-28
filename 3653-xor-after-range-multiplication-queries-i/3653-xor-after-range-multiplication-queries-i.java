class Solution {
    static int MOD = 1000000007;
    public static void solution(int nums[], int arr[]){

        int idx = arr[0];
        int r = arr[1];
        int multi = arr[3];
        int inc = arr[2];
        
        int n = nums.length;
        while(idx<=r && idx<n){
            
            nums[idx] = (int)((1L*nums[idx]*multi)%MOD);
            idx+=inc;
        }

    }
    public int xorAfterQueries(int[] nums, int[][] queries) {
        

        for(int arr[] : queries){
            solution(nums,arr);
        }

        int res = 0;

        for(int ele : nums){
            res ^=ele;
        }

        return res;

    }
}