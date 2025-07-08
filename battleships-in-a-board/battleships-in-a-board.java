// LeetCode: Battleships in a Board (battleships-in-a-board)
// Submission ID: 1690145746
// Language: java
// Timestamp (UTC): 2025-07-08T00:01:32Z

class Solution {
   static int dir[][] = {{1,0},{-1,0},{0,1},{0,-1}};
   static int m,n;
   public static void dfs(int i, int j, char board[][], boolean visited[][]){
    visited[i][j] = true;

    for(int d[] : dir){
        int nRow = i+d[0];
        int nCol = j+d[1];

        if(nRow>=0 && nCol>=0 && nRow<m && nCol<n && !visited[nRow][nCol] && board[nRow][nCol] == 'X'){
            dfs(nRow,nCol,board,visited);
        }
    }

   }
    public int countBattleships(char[][] board) {
      int  count = 0;
      m = board.length;
      n = board[0].length;
      boolean visited[][] = new boolean[m][n];
        for(int i = 0; i<board.length; i++){
            for(int j = 0; j<board[0].length; j++){
                if(board[i][j] == 'X' && !visited[i][j]){
                    dfs(i,j,board,visited);
                    count++;
                }
            }
        }

        return count;
    }
}