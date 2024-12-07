// LeetCode: Shortest Bridge (shortest-bridge)
// Submission ID: 1472355898
// Language: java
// Timestamp (UTC): 2024-12-07T05:46:17Z

class Solution {
    class Pair{
		int row;
		 int col;
		 Pair(int row, int col){
			 this.row = row;
			  this.col = col;
		 }
	}
	
	  public int shortestBridge(int[][] grid) {
		  Queue<Pair> q = new LinkedList<>();
			boolean visited[][] = new boolean[grid.length][grid[0].length];
			boolean condn = false;
			
			for(int i = 0; i<grid.length; i++) {
				if(condn)break;
				for(int j = 0; j<grid[0].length; j++) {
					if(grid[i][j] == 1) {
						dfs(i,j,grid,visited,q);
						condn = true;
						break;
					}
				}
			}
			
			int[][] dir = {{-1,0},{1,0},{0,1},{0,-1}};
			
			int level = 0;
			
			while(q.size()!=0) {
				int size = q.size();
				
				while(size-->0) {
					Pair rem = q.poll();
					
					for(int i = 0; i<4; i++) {
						int nRow = rem.row+dir[i][0];
						int nCol = rem.col+dir[i][1];
						
						if(nRow>=0 && nCol>=0 && nRow<grid.length && nCol<grid[0].length && visited[nRow][nCol] == false) {
							if(grid[nRow][nCol] == 1) {
								return level;
							}
							else {
								visited[nRow][nCol] = true;
								q.add(new Pair(nRow,nCol));
							}
						}
					}
				}
				level++;
			}
			
			return level;
	    }
	private void dfs(int i, int j, int[][] grid, boolean[][] visited,Queue<Pair> q) {
		
		if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j] == 0 || visited[i][j] == true) {
			return;
		}
		
		visited[i][j] = true;
		q.add(new Pair(i,j));
		dfs(i+1, j, grid, visited,q);
		dfs(i-1, j, grid, visited,q);
		dfs(i, j-1, grid, visited,q);
		dfs(i, j+1, grid, visited,q);
		
		
	}
}