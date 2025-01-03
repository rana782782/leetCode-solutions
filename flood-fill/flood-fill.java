// LeetCode: Flood Fill (flood-fill)
// Submission ID: 1496287540
// Language: java
// Timestamp (UTC): 2025-01-03T13:42:01Z

class Solution {
    int dir[][] = {{-1,0},{1,0},{0,-1},{0,1}};
	 public int[][] floodFill(int[][] image, int sr, int sc, int color) {
	        int original = image[sr][sc];
	        
	        if(original == color) {
	        	return image;
	        }
	        
	       
	        
	        dfs(image,sr,sc,color,original);
	        
	        
	        return image;
	        	
	        
	        
	        
	    }

	private void dfs(int[][] image, int sr, int sc, int color, int original) {
		// TODO Auto-generated method stub
		if(sr<0 || sr>=image.length || sc<0 || sc>=image[0].length || image[sr][sc] == color || image[sr][sc]!=original) {
    		return;
    	}
		
		image[sr][sc] = color;
		
		for(int d[] : dir) {
			dfs(image, sr+d[0], sc+d[1], color, original);
		}
		
	}
}