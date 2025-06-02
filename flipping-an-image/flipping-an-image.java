// LeetCode: Flipping an Image (flipping-an-image)
// Submission ID: 1651688628
// Language: java
// Timestamp (UTC): 2025-06-02T13:02:05Z

class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        
        for(int d[] : image){
            int n = d.length;
            for(int i = 0; i<d.length/2; i++){
                
                
                int temp = d[i];
                d[i] = d[n-1-i];
                d[n-1-i] = temp;
            }
        }
        
        
        for(int i = 0; i<image.length; i++){
            for(int j = 0; j<image[0].length; j++){
                if(image[i][j] == 0)image[i][j] = 1;
                else{
                    image[i][j] = 0;
                }
            }
        }
        
        return image;
    }
}