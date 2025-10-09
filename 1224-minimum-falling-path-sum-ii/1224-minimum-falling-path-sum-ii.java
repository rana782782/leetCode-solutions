class Solution {
    static int n;
    static Integer memo[][];
   
    public static int dfs(int row,int col,int grid[][]){
            if(row == n-1)return grid[row][col];

            if(memo[row][col]!=null)return memo[row][col];
             int temp = Integer.MAX_VALUE;
           
           for(int j = 0; j<n; j++){
            if(j!=col){
                
        
               temp = Math.min(temp,dfs(row+1,j,grid));
            
                
            }
           }
  
        return memo[row][col] = temp == Integer.MAX_VALUE ? Integer.MAX_VALUE : temp+grid[row][col];




            
    }

    public int minFallingPathSum(int[][] grid) {
        n = grid.length;
        memo = new Integer[n+1][n+1];
        int output = Integer.MAX_VALUE;

        for(int j = 0; j<grid[0].length; j++){
            output = Math.min(output,dfs(0,j,grid));
        }

        return output;
    }
}