// LeetCode: As Far from Land as Possible (as-far-from-land-as-possible)
// Submission ID: 1471798575
// Language: java
// Timestamp (UTC): 2024-12-06T11:40:31Z

class Solution {
   class Pair{
		int row;
		 int col;
		  Pair(int row, int col){
			  this.row = row;
			  this.col = col;
		  }
	}
	  public int maxDistance(int[][] grid) {
	        int dir[][] = {{-1,0},{1,0},{0,1},{0,-1}};
	        
	        Queue<Pair> q = new LinkedList<>();
	       
	        for(int i = 0; i<grid.length; i++) {
	        	for(int j = 0; j<grid[0].length; j++) {
	        		
	        		if(grid[i][j] == 1) {
	        			q.add(new Pair(i,j));
	        		}
	        		
	        	}
	        }
	        
	        if (q.isEmpty() || q.size() == grid.length * grid[0].length) {
	            return -1;
	        }
	        
    int max = 0;
	        
	        while(q.size()!=0) {
	        	Pair rem = q.poll();
	        	
	        	for(int i = 0; i<4; i++) {
	        		int nRow = rem.row+dir[i][0];
	        		int nCol = rem.col+dir[i][1];
	        		
	        		if(nRow>=0 && nCol>=0 && nRow<grid.length && nCol<grid[0].length && grid[nRow][nCol] == 0) {
	        			grid[nRow][nCol] = grid[rem.row][rem.col]+1;
	        			q.add(new Pair(nRow,nCol));
	        			
	        			max = Math.max(max, grid[nRow][nCol]);
	        		}
	        	}
	        }
	        
	        
	        
	       
	        
	        return max-1;
	  }
}