// LeetCode: 3Sum Closest (3sum-closest)
// Submission ID: 1383155480
// Language: java
// Timestamp (UTC): 2024-09-08T11:43:17Z

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int output = Integer.MAX_VALUE;
        int ans = 0;

        for(int i = 0; i<n-2; i++){

            if(i>0 && nums[i] == nums[i-1]) i++;

            int j = i+1;
             int k = n-1;

             while(j<k){
                int diff = target-(nums[i]+nums[j]+nums[k]);
                int sum = nums[i]+nums[j]+nums[k];

                if(sum>target){
                    diff = Math.abs(diff);
                  if(diff<output){
                    output = diff;
                    ans = sum;
                  }
                    k--;
                }

                else if(sum<target){
                    diff = Math.abs(diff);
                    if(diff<output){
                        output = diff;
                        ans = sum;
                    }
                    j++;
                }
                else{
                    output = 0;
                    ans = sum;
                    j++;
                    k--;

                    while(j<k && nums[j] == nums[j-1])j++;
                    while(j<k && nums[k] == nums[k-1])k--;
                }
             }
        }

        return ans;

    }
}