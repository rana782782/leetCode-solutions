// LeetCode: Number of Operations to Make Network Connected (number-of-operations-to-make-network-connected)
// Submission ID: 1496109833
// Language: java
// Timestamp (UTC): 2025-01-03T09:57:18Z

class Solution {
   public static class Pair{
		int src;
		 int dest;
		 Pair(int src, int dest){
			 this.src = src;
			  this.dest = dest;
		 }
	}
	
public int makeConnected(int n, int[][] connections) {
	
	if(connections.length<n-1) {
		return -1;
	}
       boolean visited[] = new boolean[n];
       
       ArrayList<ArrayList<Pair>> graph = new ArrayList<>();
       
       for(int i = 0; i<n; i++) {
    	   graph.add(new ArrayList<>());
       }
       
       
       for(int i = 0; i<connections.length; i++) {
    	   int u = connections[i][0];
    	    int v = connections[i][1];
    	    
    	    graph.get(u).add(new Pair(u,v));
    	    graph.get(v).add(new Pair(v,u));
       }
       
       int ans = 0;
       
       
       for(int i = 0; i<n; i++) {
    	   if(!visited[i]) {
    		   dfs(i,graph,visited);
    		   ans++;
    	   }
       }
       
       return ans-1;
       
    }



	private void dfs(int i, ArrayList<ArrayList<Pair>> graph, boolean[] visited) {
	// TODO Auto-generated method stub
		visited[i] = true;
		
		for(Pair p : graph.get(i)) {
			if(!visited[p.dest]) {
				dfs(p.dest, graph, visited);
			}
		}
	
}
}