// LeetCode: Rotate Image (rotate-image)
// Submission ID: 1689645468
// Language: java
// Timestamp (UTC): 2025-07-07T14:24:55Z

class Solution {
    static int n;
    public static void transpose(int mat[][]){
      for(int i = 0; i<n; i++){
          for(int j = i+1; j<n; j++){
              int temp = mat[i][j];
              
              mat[i][j] = mat[j][i];
              mat[j][i] = temp;
              
          }
      }
    }
    
    public static void mirror(int mat[][]){
        
        for(int i =0; i<n; i++){
            for(int j = 0; j<n/2; j++){
                
                int temp = mat[i][j];
                mat[i][j] = mat[i][n-j-1];
                mat[i][n-j-1] = temp;
            }
        }
    }
    public void rotate(int[][] matrix) {
        n = matrix.length;
        transpose(matrix);
        mirror(matrix);
    }
}