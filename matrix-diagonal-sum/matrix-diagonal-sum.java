// LeetCode: Matrix Diagonal Sum (matrix-diagonal-sum)
// Submission ID: 1652037810
// Language: java
// Timestamp (UTC): 2025-06-02T19:07:56Z

class Solution {
    public int diagonalSum(int[][] mat) {
        int n = mat.length;
        
        int output = 0;
        
        for(int i = 0; i<n; i++){
            output+=mat[i][i];
        }
        
        for(int i = 0; i<n; i++){
            output+=mat[i][n-i-1];
        }
        
        if(n%2!=0){
            output-=mat[n/2][n/2];
        }
        
        
        return output;
    }
}