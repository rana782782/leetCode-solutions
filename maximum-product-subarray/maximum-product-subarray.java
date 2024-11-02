// LeetCode: Maximum Product Subarray (maximum-product-subarray)
// Submission ID: 1440776284
// Language: java
// Timestamp (UTC): 2024-11-02T13:06:50Z

class Solution {
    public int maxProduct(int[] nums) {
        int currProduct = 1;
        int ans = Integer.MIN_VALUE;
        for(int i = 0; i<nums.length; i++){
              currProduct*=nums[i];
              ans = Math.max(currProduct,ans);
              if(currProduct == 0){
                currProduct = 1;
              }
        }

        currProduct = 1;

        for(int i = nums.length-1; i>=0; i--){
            currProduct*=nums[i];
            ans = Math.max(ans,currProduct);
            if(currProduct == 0){
                currProduct = 1;
            }
        }

        return ans;
    }
}