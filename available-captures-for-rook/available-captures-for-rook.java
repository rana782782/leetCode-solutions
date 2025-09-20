// LeetCode: Available Captures for Rook (available-captures-for-rook)
// Submission ID: 1776863904
// Language: java
// Timestamp (UTC): 2025-09-20T09:30:44Z

class Solution {
    static int dir[][] = {{1,0},{0,1},{0,-1},{-1,0}};
    public static boolean isPossible(int row,int col,int d[],char board[][]){
        int moveX = d[0];
        int moveY = d[1];
        row+=moveX;
        col+=moveY;

        while(row>=0 && col>=0 && row<8 && col<8){
            if(board[row][col] =='B')return false;
            else if(board[row][col] == 'p')return true;

            row+=moveX;
            col+=moveY;

        }

        return false;
    }
    public int numRookCaptures(char[][] board) {
        int output = 0;

        int row = -1; int col = -1;

        for(int i = 0; i<8; i++){
                for(int j = 0; j<8; j++){
                    if(board[i][j] == 'R'){
                        row = i;
                        col = j;
                    }
                }
        }


        for(int d[] : dir){

            if(isPossible(row,col,d,board))output++;
        }

        return output;
    }
}