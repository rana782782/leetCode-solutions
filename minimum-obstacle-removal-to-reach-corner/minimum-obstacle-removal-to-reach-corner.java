// LeetCode: Minimum Obstacle Removal to Reach Corner (minimum-obstacle-removal-to-reach-corner)
// Submission ID: 1472655112
// Language: java
// Timestamp (UTC): 2024-12-07T14:40:28Z

class Solution {
    	class Pair  implements Comparable<Pair>{
		int row;
		 int col;
		  int wt;
		  Pair(int row, int col, int wt){
			  this.row = row;
			  this.col = col;
			  this.wt = wt;
		  }
		  public int compareTo(Pair o) {
			  return this.wt-o.wt;
		  }
	}

	   public int minimumObstacles(int[][] grid) {
		   int n = grid.length;
			  int m = grid[0].length;
			  
			  if(n == 1 && m == 1)return 0;
			  boolean visited[][] = new boolean[n][m];
		  PriorityQueue<Pair> pq = new PriorityQueue<>();
		  pq.add(new Pair(0,0,0));
		  visited[0][0] = true;
		  
		
		  int dir[][] = {{-1,0},{1,0},{0,-1},{0,1}};
		  
		  while(pq.size()!=0) {
			  Pair rem = pq.poll();
			  
			  
			 
			  
			  if(rem.row == n-1 && rem.col == m-1) {
				 
				  return rem.wt;
			  }
			  
			  for(int i = 0; i<4; i++) {
				  int nRow = rem.row+dir[i][0];
				  int nCol = rem.col+dir[i][1];
				  
				  if(nRow>=0 && nCol>=0 && nRow<n && nCol<m && visited[nRow][nCol] == false) {
					  pq.add(new Pair(nRow,nCol,rem.wt+grid[nRow][nCol]));
                       visited[nRow][nCol] = true;
					  
				  }
			  }
			  
		  }
		  
		  return -1;
		 
		  
		  
	    }
}