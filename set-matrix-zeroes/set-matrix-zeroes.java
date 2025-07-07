// LeetCode: Set Matrix Zeroes (set-matrix-zeroes)
// Submission ID: 1690096734
// Language: java
// Timestamp (UTC): 2025-07-07T21:59:13Z

class Solution {
    public void setZeroes(int[][] matrix) {
        HashSet<Integer>setRow = new HashSet<>();
        HashSet<Integer>setCol = new HashSet<>();
        
        for(int i = 0; i<matrix.length; i++){
            for(int j = 0; j<matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    setRow.add(i);
                    setCol.add(j);
                }
            }
        }
        
        for(int row : setRow){
            for(int col = 0; col<matrix[0].length; col++){
                matrix[row][col] = 0;
            }
        }
        
        for(int col : setCol){
            for(int row = 0; row<matrix.length; row++){
                matrix[row][col] = 0;
            }
        }
    }
}