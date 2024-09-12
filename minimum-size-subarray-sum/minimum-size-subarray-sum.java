// LeetCode: Minimum Size Subarray Sum (minimum-size-subarray-sum)
// Submission ID: 1387586520
// Language: java
// Timestamp (UTC): 2024-09-12T11:04:24Z

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int i = -1;
         int j = -1;
          int ans = 0;
           int sum = 0;

           while(true){
            boolean f1 = false;
            boolean f2 = false;
   while(i<nums.length-1){
    f1 = true;
            i++;
            sum+=nums[i];
            if(sum>=target){
                int length = i-j;
                if(ans == 0 || length<ans){
                    ans = length;
                }
                break;
            }
           }

           while( j<i){
            f2 = true;
            j++;
             sum-=nums[j];
             if(sum>=target){
                 int length = i-j;
                if(ans == 0 || length<ans){
                    ans = length;
                }
             }
             else if(sum<target){
                break;
             }
           }
            if(f1 == false && f2 == false){
                break;
            }
           }

           return ans;

        
    }
}