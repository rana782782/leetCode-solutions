// LeetCode: Nearest Exit from Entrance in Maze (nearest-exit-from-entrance-in-maze)
// Submission ID: 1589410576
// Language: java
// Timestamp (UTC): 2025-03-28T18:19:16Z

class Solution {
   	public static class Pair{
		int row;
		 int col;
		 
		 Pair(int row, int col){
			 this.row = row;
			 this.col = col;
					 
		 }
	}
	static int dir[][] = {{-1,0},{1,0},{0,1},{0,-1}};
	
	 public static int nearestExit(char[][] maze, int[] entrance) {
	        int m = maze.length;
	        int n = maze[0].length;
	        
	        Queue<Pair> q = new LinkedList<>();
	        q.add(new Pair(entrance[0],entrance[1]));
	        
	        int ans = 0;
	        
	        boolean visited[][] = new boolean[m][n];
            visited[entrance[0]][entrance[1]] = true;
	        
	        while(q.size()!=0) {
	        	int size = q.size();
	        	
	        	while(size-->0) {
	        		Pair rem = q.poll();
	        		
	        		if(ans!=0) {
	        			int nRow = rem.row;
	        			int nCol = rem.col;
	        			
	        			
	        			if(nRow == 0 || nRow == m-1 || nCol == 0 || nCol == n-1) return ans;
	        		}
	        		
	        		for(int d[] : dir) {
	        			int nRow = rem.row+d[0];
	        			int nCol = rem.col+d[1];
	        			
	        			if(nRow>=0 && nRow<m && nCol>=0 && nCol<n && maze[nRow][nCol] == '.' && !visited[nRow][nCol]) {
	        				visited[nRow][nCol] = true;
	        				q.add(new Pair(nRow,nCol));
	        			}
	        		}
	        		
	        		
	        	}
                ans++;
	        	
	        	
	        }
	        
	        return -1;
	    }
}