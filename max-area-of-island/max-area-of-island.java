// LeetCode: Max Area of Island (max-area-of-island)
// Submission ID: 1496266577
// Language: java
// Timestamp (UTC): 2025-01-03T13:18:16Z

class Solution {
   static int area;
	int dir[][] = {{-1,0},{1,0},{0,1},{0,-1}};

	 public int maxAreaOfIsland(int[][] grid) {
	     int output = 0;
	     
	     for(int i = 0; i<grid.length; i++) {
	    	 
	    	 for(int j = 0; j<grid[0].length; j++) {
	    		 
	    		 if(grid[i][j] == 1) {
	    			 area = 0;
	    			 dfs(grid,i,j);
	    			 output = Math.max(output,area);
	    		 }
	    	 }
	     }
	     
	    
	     
	     return output;
	    }
	private void dfs(int[][] grid, int i, int j) {
		if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j] == 0) {
			return;
		}
		
		area+=1;
		
		grid[i][j] = 0;
		
		for(int d[] : dir) {
			dfs(grid, i+d[0], j+d[1]);
		}
		
	}
}