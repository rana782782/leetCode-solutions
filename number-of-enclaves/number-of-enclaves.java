// LeetCode: Number of Enclaves (number-of-enclaves)
// Submission ID: 1470768868
// Language: java
// Timestamp (UTC): 2024-12-05T06:14:36Z

class Solution {
   	   public int numEnclaves(int[][] grid) {
	     
	     
	        for(int i = 0; i<grid.length; i++) {
	        	for(int j = 0; j<grid[0].length; j++) {
	        		if( i == 0 || j == 0 || i == grid.length-1 || j == grid[0].length-1) {
	        			if(grid[i][j] == 1) {
	        				
							solve(grid,i,j);
	        			}
	        		}
	        	}
	        }
	        
	        int count = 0;
	        
	        for(int i = 0; i<grid.length; i++) {
	        	for(int j = 0; j<grid[0].length; j++) {
	        		if(grid[i][j] == 1) {
	        			count++;
	        		}
	        	}
	        }
	        
	        return count;
	    }

	private static void solve(int[][] grid, int i, int j) {
		if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j] == 0 ) {
			return;
		}
		grid[i][j] = 0;
		solve(grid,  i+1, j);
		solve(grid, i-1, j);
		solve(grid,i, j+1);
		solve(grid, i, j-1);
		
	}
}