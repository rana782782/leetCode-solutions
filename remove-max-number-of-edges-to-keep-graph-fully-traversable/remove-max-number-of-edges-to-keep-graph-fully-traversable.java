// LeetCode: Remove Max Number of Edges to Keep Graph Fully Traversable (remove-max-number-of-edges-to-keep-graph-fully-traversable)
// Submission ID: 1473455759
// Language: java
// Timestamp (UTC): 2024-12-08T12:06:40Z

class Solution {
   public static int find(int x, int[] parent) {
		if(parent[x] == x) {
			return x;
		}
		int temp = find(parent[x],parent);
		parent[x] = temp;
		return temp;
	}
	
	public static boolean union(int x, int y,int parent[], int rank[]) {
		int lx = find(x,parent);
		int ly = find(y,parent);
		
		if(lx!=ly) {
			if(rank[lx]>rank[ly]) {
				parent[ly] = lx;
			}
			else if(rank[lx]<rank[ly]) {
				parent[lx] = ly;
			}
			else {
				parent[lx] = ly;
				rank[ly]++;
			}
			
			return true;
		}
		
		return false;
	}
	
	 public int maxNumEdgesToRemove(int n, int[][] edges) {
		 Arrays.sort(edges,(a,b)->Integer.compare(b[0], a[0]));
	        int parentA[] = new int[n+1];
	        int parentB[] = new int[n+1];
	        int rankA[] = new int[n+1];
	        int rankB[] = new int[n+1];
	        
	        int meargedA = 1;
	        int meargedB = 1;
	        int removed = 0;
	        
	        for(int i = 0; i<n; i++) {
	        	parentA[i] = i;
	        	parentB[i] = i;
	        	rankA[i] = 1;
	        	rankB[i] = 1;
	        }
	        
	        
	        for(int e[]: edges) {
	        	if(e[0] == 3) {
	        		boolean tempA = union(e[1],e[2], parentA, rankA);
	        		boolean tempB = union(e[1],e[2], parentB, rankB);
	        		
	        		if(tempA) {
	        			meargedA++;
	        		}
	        		if(tempB) {
	        			meargedB++;
	        		}
	        		
	        		if(tempA == false && tempB == false) {
	        			removed++;
	        		}
	        	}
	        	else if(e[0] == 1) {
	        		boolean tempA = union(e[1],e[2], parentA, rankA);
	        		if(tempA) {
	        			meargedA++;
	        		}
	        		else {
	        			removed++;
	        		}
	        	}
	        	
	        	else {
	        		boolean tempB = union(e[1],e[2], parentB, rankB);
	        		if(tempB) {
	        			meargedB++;
	        		}
	        		else {
	        			removed++;
	        		}
	        		
	        	}
	        }
	        
	        if(meargedA!=n || meargedB!=n) {
	        	return -1;
	        }
	        
	        return removed;
	    }

}