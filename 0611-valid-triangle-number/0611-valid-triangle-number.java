class Solution {
    public int triangleNumber(int[] nums) {
        int output = 0;

        Arrays.sort(nums);

        for(int i = nums.length-1; i>1; i--){

            int j = i-1;
            int k = 0;

                while(k<j){
                    if(nums[j]+nums[k]>nums[i]){
                    output+=j-k;
                    j--;
                }
                else{
                    k++;
                }
               
                }
            }

            return output;
        }
    }
