// LeetCode: Find if Path Exists in Graph (find-if-path-exists-in-graph)
// Submission ID: 1495087683
// Language: java
// Timestamp (UTC): 2025-01-02T12:51:19Z

class Solution {
   	 public static boolean solution(ArrayList<ArrayList<Integer>> graph, int src, int dest, boolean visited[]) {
		 if(src == dest) {
			 return true;
		 }
		 
		 visited[src] = true;
		 
		 
		 ArrayList<Integer> nbrs = graph.get(src);
		 
		 for(int i : nbrs) {
			 if(!visited[i]) {
				 boolean output = solution(graph,i,dest,visited);
				 if(output) {
					 return true;
				 }
			 }
		 }
		 
		 
		 return false;
	 }
	 
	 public boolean validPath(int n, int[][] edges, int source, int destination) {
	        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	        
	        for(int i = 0; i<n; i++) {
	        	graph.add(new ArrayList<>());
	        }
	        
	        for(int i = 0; i<edges.length; i++) {
	        	int u = edges[i][0];
	        	
	        	int v = edges[i][1];
	        	
	        	
	        	graph.get(u).add(v);
	        	graph.get(v).add(u);
	        	
	        }
	        
	        boolean visited[] = new boolean[n];
	        boolean output = solution(graph, source, destination, visited);
	        return output;
	    }
	 
}