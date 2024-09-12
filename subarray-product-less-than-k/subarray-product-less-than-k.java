// LeetCode: Subarray Product Less Than K (subarray-product-less-than-k)
// Submission ID: 1387679088
// Language: java
// Timestamp (UTC): 2024-09-12T13:10:42Z

class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int j = 0;
        int product = 1;
        int ans = 0;
        for(int i = 0; i<nums.length; i++){
            product*=nums[i];

            while(j<=i && product>=k){
                product = product/nums[j];
                j++;
            }
            ans+=i-j+1;
        }

        return ans;
    }
}