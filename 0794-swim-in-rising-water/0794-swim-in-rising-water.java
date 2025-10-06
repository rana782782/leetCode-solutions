class Solution {
   class Pair implements Comparable<Pair>{
		int row;
		 int col;
		 int wt;
		 
		 Pair(int row, int col , int wt){
			 this.row = row;
			  this.col = col;
			  this.wt = wt;
		 }
		 
		 public int compareTo(Pair o) {
			 return this.wt-o.wt;
		 }
	}

	
	 public int swimInWater(int[][] grid) {
	        
		 boolean visited[][] = new boolean[grid.length][grid[0].length];
		 int n = grid.length;
		 int m = grid[0].length;
		 
		 PriorityQueue<Pair> pq = new PriorityQueue<>();
		 pq.add(new Pair(0,0,grid[0][0]));
		 int dir[][] = {{-1,0},{1,0},{0,-1},{0,1}};
		 
		 int max = Integer.MIN_VALUE;
		 
		 while(pq.size()!=0) {
			 Pair rem = pq.poll();
			 max = Math.max(max,rem.wt);
			 if(rem.row == n-1 && rem.col == m-1) {
				 return max;
			 }
			 visited[rem.row][rem.col] = true;
			 
			 for(int i = 0; i<4; i++) {
				 int nRow = rem.row+dir[i][0];
				 int nCol = rem.col+dir[i][1];
				 
				 if(nRow>=0 && nCol>=0 && nRow<grid.length && nCol<grid[0].length && visited[nRow][nCol] == false) {
					 pq.add(new Pair(nRow,nCol,grid[nRow][nCol]));
					
					 
				 }
			 }
		 }
		 
		 return max;
	    }
}