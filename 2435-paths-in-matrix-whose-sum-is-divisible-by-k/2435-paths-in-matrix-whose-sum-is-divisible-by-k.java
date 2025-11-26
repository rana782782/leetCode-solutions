class Solution {
    static int m,n;
    static int MOD = 1000000007;
    static int dir[][] = {{1,0},{0,1}};
    static int dp[][][];
    public static int solution(int i, int j, int grid[][], int sum,int k){
        if(i == m-1 && j == n-1){
             if(sum == 0)return 1;

             return 0;
        }

        if(dp[i][j][sum]!=-1)return dp[i][j][sum];

        int total = 0;
        

        for(int d[] : dir){
            int nRow = i+d[0];
            int nCol = j+d[1];

            if(nRow>=0 && nCol>=0 && nRow<m && nCol<n){
               int numAdd = grid[nRow][nCol];
                total = (total+solution(nRow,nCol,grid,(sum+numAdd)%k,k))%MOD;
            }
        }

     
        return dp[i][j][sum] = total%MOD;

    }
    public int numberOfPaths(int[][] grid, int k) {
        m = grid.length;
        n = grid[0].length;

        dp = new int[m+1][n+1][k+1];

        for(int towD[][] : dp){
            for(int oneD[] : towD){
                Arrays.fill(oneD,-1);
            }
        }
       

        return solution(0,0,grid,grid[0][0]%k,k);
    }
}