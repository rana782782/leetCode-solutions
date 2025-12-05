class Solution {
    public int countPartitions(int[] nums) {
        int total = 0;
        int n = nums.length;
        int arr[] = new int[n];


        int curr_sum = 0;

        for(int i = 0; i<n; i++){
            curr_sum+=nums[i];
            arr[i] = curr_sum;
        }
        total = curr_sum;

        int output = 0;
        for(int i = 0; i<n-1; i++){
            int rem = total-arr[i];

            int diff = Math.abs(arr[i]-rem);
            if(diff%2 == 0)output++;
        }

        return output;
    }
}