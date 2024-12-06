// LeetCode: 01 Matrix (01-matrix)
// Submission ID: 1471766911
// Language: java
// Timestamp (UTC): 2024-12-06T10:40:08Z

class Solution {
   	class Pair{
		int row;
		 int col;
		 Pair(int row, int col){
			 this.row = row;
			 this.col = col;
		 }
	}

	 public int[][] updateMatrix(int[][] mat) {
	        Queue<Pair> q = new LinkedList<>();
	        
	        int dir[][] = {{-1,0},{1,0},{0,-1},{0,1}};
	        
	        for(int i = 0; i<mat.length; i++) {
	        	for(int j = 0; j<mat[0].length; j++) {
	        		if(mat[i][j] == 0) {
	        			q.add(new Pair(i,j));
	        		}
	        		
	        		else {
	        			mat[i][j] = -1;
	        		}
	        	}
	        }
	        
	        while(q.size()!=0) {
	        	Pair rem = q.poll();
	        	
	        	for(int i = 0; i<4; i++) {
	        		int nRow = rem.row+dir[i][0];
	        		
	        		int nCol = rem.col+dir[i][1];
	        		
	        		
	        		if(nRow>=0 && nCol>=0 && nRow<mat.length && nCol<mat[0].length && mat[nRow][nCol]<0) {
	        			
	        			mat[nRow][nCol] = mat[rem.row][rem.col]+1;
	        			q.add(new Pair(nRow,nCol));
	        		}
	        	}
	        }
	        
	        return mat;
	    }
}