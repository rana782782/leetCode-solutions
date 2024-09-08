// LeetCode: Trapping Rain Water (trapping-rain-water)
// Submission ID: 1383237001
// Language: java
// Timestamp (UTC): 2024-09-08T13:28:12Z

class Solution {
    public int trap(int[] height) {
         int left_max[] = new int[height.length];
         int right_max[] = new int[height.length];

         for(int i = 0; i<height.length; i++){
            if(i == 0){
                left_max[i] = height[i];
            }
            else{
                left_max[i] = Math.max(height[i],left_max[i-1]);
            }
         }

         for(int i = height.length-1; i>=0; i--){
            if(i == height.length-1){
                right_max[i] = height[i];
            }
            else{
                right_max[i] = Math.max(height[i],right_max[i+1]);
            }
         }

         int waterTrapped = 0;

         for(int i = 0; i<height.length; i++){
            waterTrapped+=Math.min(left_max[i],right_max[i])-height[i];
         }

         return waterTrapped;
    }
}