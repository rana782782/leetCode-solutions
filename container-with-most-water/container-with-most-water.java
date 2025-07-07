// LeetCode: Container With Most Water (container-with-most-water)
// Submission ID: 1689629861
// Language: java
// Timestamp (UTC): 2025-07-07T14:10:27Z

class Solution {
    public int maxArea(int[] height) {
        int output = 0;
        
          int start = 0;
           int end = height.length-1;
        
        while(start<=end){
            
            int wt = Math.min(height[start],height[end]);
            
            int area = wt*(end-start);
            
            output = Math.max(output,area);
            
            if(height[start]<height[end]){
                start++;
            }
            else if(height[start]>height[end]){
                end--;
            }
            else{
                start++;
                end--;
            }
        }
        
        return output;
    }
}