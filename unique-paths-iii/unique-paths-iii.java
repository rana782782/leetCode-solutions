// LeetCode: Unique Paths III (unique-paths-iii)
// Submission ID: 1586560166
// Language: java
// Timestamp (UTC): 2025-03-26T06:29:22Z

class Solution {
        static int M,N;
        static int dir[][] = {{-1,0},{1,0},{0,1},{0,-1}};
        static int org;
    public static int solution(int row, int col, int grid[][], int pathLength){
            if(row<0 || row>=M || col<0 || col>=N || grid[row][col] == -1) return 0;

            if(grid[row][col] == 2){
                return pathLength == org ? 1 : 0;
            }
            int temp = grid[row][col];
            grid[row][col] = -1;
            int ans = 0;

            for(int d[] : dir){
                int nRow = row+d[0];
                int nCol = col+d[1];
                ans+=solution(nRow,nCol,grid,pathLength+1);

            }

            grid[row][col] = temp;

            return ans;
    }
    public int uniquePathsIII(int[][] grid) {
          int m = grid.length;
          int n = grid[0].length;
          M = m;
          N = n;

          int totalBoxes = m*n-1;

          for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(grid[i][j] == -1) totalBoxes--;
            }
          }

          org = totalBoxes;

          for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(grid[i][j] == 1) return solution(i,j,grid,0);
            }
          }

            return 0;
    }
}