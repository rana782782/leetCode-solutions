// LeetCode: Smallest Rectangle Enclosing Black Pixels (smallest-rectangle-enclosing-black-pixels)
// Submission ID: 1644515734
// Language: java
// Timestamp (UTC): 2025-05-26T00:57:19Z

class Solution {
    static int minRow,minCol,maxRow,maxCol,m,n;
    static int dir[][] = {{1,0},{-1,0},{0,1},{0,-1}};
    public static void dfs(int i, int j, char image[][], boolean visited[][]){
        visited[i][j] = true;

        for(int d[] : dir){
            int nRow = i+d[0];
            int nCol = j+d[1];

            if(nRow>=0 && nCol>=0 && nRow<m && nCol<n && !visited[nRow][nCol] && image[nRow][nCol]-'0' == 1){
                minRow = Math.min(minRow,nRow);
                maxRow = Math.max(maxRow,nRow);
                minCol = Math.min(minCol,nCol);
                maxCol = Math.max(maxCol,nCol);
                dfs(nRow,nCol,image,visited);
            }
        }

    }
    public int minArea(char[][] image, int x, int y) {
        minRow = x;
        minCol = y;
        maxRow = x;
        maxCol = y;
        m = image.length;
        n = image[0].length;
        boolean visited[][] = new boolean[m][n];

        dfs(x,y,image,visited);

        int area = (maxRow-minRow+1)*(maxCol-minCol+1);
        return area;
    }
}