// LeetCode: Rotate Function (rotate-function)
// Submission ID: 1444833741
// Language: java
// Timestamp (UTC): 2024-11-06T14:03:27Z

class Solution {
    public int maxRotateFunction(int[] nums) {
        int sum = 0;
        int prevSum = 0;
        for(int i = 0; i<nums.length; i++){
            sum+=nums[i];
            prevSum+=(nums[i]*i);
        }
        
          int n = nums.length-1;
          int j = n;
          
        
          int output = prevSum;
        
          while(j>=1){
              prevSum = prevSum-(nums[j]*n)+sum-nums[j];
              System.out.print(prevSum+" ");
              output = Math.max(prevSum,output);
              j--;
          }

          return output;
    }
}