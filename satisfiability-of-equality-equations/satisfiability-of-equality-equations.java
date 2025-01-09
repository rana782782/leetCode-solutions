// LeetCode: Satisfiability of Equality Equations (satisfiability-of-equality-equations)
// Submission ID: 1502894006
// Language: java
// Timestamp (UTC): 2025-01-09T11:26:53Z

class Solution {
  	static int parent[];
	static int rank[];
	
	
	public static int find(int x) {
		if(parent[x] == x) return x;
		
		int temp = find(parent[x]);
		parent[x] = temp;
		
		return temp;
	}
	
	public static void union(int x, int y) {
		int lx = find(x);
		 int ly = find(y);
		 
		 if(rank[lx]>rank[ly]) {
			 parent[ly] = lx;
		 }
		 
		 else if(rank[ly]>rank[lx]) {
			 parent[lx] = ly;
		 }
		 
		 else {
			 parent[lx] = ly;
			 rank[ly]++;
		 }
	}
	  public boolean equationsPossible(String[] equations) {
	        parent = new int[26];
	        rank = new int[26];
	        
	        
	        for(int i = 0; i<parent.length; i++) {
	        	parent[i] = i;
	        	rank[i] = 1;
	        }
	        
	        for(String eq : equations) {
	        	
	        	if(eq.charAt(1) == '=') {
	        		union(eq.charAt(0)-'a', eq.charAt(3)-'a');
	        	}
	        }
	        
 for(String eq : equations) {
	        	
	        	if(eq.charAt(1) == '!') {
	        		int lx = find(eq.charAt(0)-'a');
	        		int ly = find(eq.charAt(3)-'a');
	        		
	        		if(ly == lx) return false;
	        	}
	        }
 
 return true;
	    }
}