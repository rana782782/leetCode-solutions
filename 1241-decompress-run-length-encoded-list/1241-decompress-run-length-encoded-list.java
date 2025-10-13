class Solution {
    public int[] decompressRLElist(int[] nums) {
        int len = 0;

        for(int i = 0; i<nums.length; i+=2){
            len+=nums[i];
        }

        int output[] = new int[len];
        int idx = 0;


        for(int i = 1; i<nums.length; i+=2){
            int val = nums[i];
             int freq = nums[i-1];
             while(freq-->0){
                output[idx++] = val;
             }
        }

        return output;
    }
}