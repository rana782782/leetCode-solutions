// LeetCode: Out of Boundary Paths (out-of-boundary-paths)
// Submission ID: 1584053085
// Language: java
// Timestamp (UTC): 2025-03-24T06:25:29Z

class Solution {
    static int M,N;

    static int dir[][] = {{-1,0},{1,0},{0,-1},{0,1}};
    static int MOD = 1000000007;
    static int memo[][][];


    public static int solution(int row, int col, int maxMove){
        if(maxMove<0) return 0;

        if(row<0 || row>=M || col<0 || col>=N) return 1;

        if(memo[row][col][maxMove]!=-1) return memo[row][col][maxMove];

        int ans = 0;

        for(int d[] : dir){
            int nRow = row+d[0];
            int nCol = col+d[1];

            ans=(ans+solution(nRow,nCol,maxMove-1))%MOD;
        }

        return memo[row][col][maxMove] = ans;
    }
    
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        M = m;
         N = n;

         memo = new int[m+1][n+1][maxMove+1];

         for(int i = 0; i<m+1; i++){
            for(int j = 0; j<n+1; j++){
                Arrays.fill(memo[i][j],-1);
            }
         }

         return solution(startRow,startColumn,maxMove);
    }
}