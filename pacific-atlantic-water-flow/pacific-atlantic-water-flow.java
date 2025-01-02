// LeetCode: Pacific Atlantic Water Flow (pacific-atlantic-water-flow)
// Submission ID: 1495420148
// Language: java
// Timestamp (UTC): 2025-01-02T18:20:37Z

class Solution {
   	 public List<List<Integer>> pacificAtlantic(int[][] heights) {
	        List<List<Integer>> output = new ArrayList<>();
	        if(heights == null || heights.length == 0 || heights[0].length == 0) {
	        	return output;
	        }
	        
	         int row = heights.length;
	          int col = heights[0].length;
	          
	          
	          boolean[][]  pacific = new boolean[row][col];
	          boolean[][]  atlantic = new boolean[row][col];
	          
	          for(int i = 0; i<row; i++) {
	        	  solution(heights, i, 0, Integer.MIN_VALUE, pacific);
	        	  solution(heights, i, col-1, Integer.MIN_VALUE, atlantic);
	          }
	          for(int i = 0; i<col; i++) {
	        	  solution(heights, 0, i,Integer.MIN_VALUE, pacific);
	        	  solution(heights, row-1, i, Integer.MIN_VALUE, atlantic);
	          }
	          
	          
	          
	          
	          
	          
	          for(int i = 0; i<row; i++) {
	        	  for(int j = 0; j<col; j++) {
	        		  if(pacific[i][j]&& atlantic[i][j]) {
	        			  output.add(Arrays.asList(i,j));
	        		  }
	        	  }
	          }
	          
	          return output;
	    }
	static int dir[][] = {{-1,0},{1,0},{0,-1},{0,1}};
	 public static void solution(int matrix[][], int i, int j, int prev, boolean[][] ocean) {
		 if(i<0 || i>=matrix.length || j<0 || j>=matrix[0].length || ocean[i][j] || (matrix[i][j]<prev)) return;
		 
		 ocean[i][j] = true;
		 
		 for(int[] d : dir) {
			 solution(matrix, i+d[0], j+d[1], matrix[i][j], ocean);
		 }
		 
		 
		 
	 }
}