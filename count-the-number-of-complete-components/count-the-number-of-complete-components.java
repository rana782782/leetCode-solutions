// LeetCode: Count the Number of Complete Components (count-the-number-of-complete-components)
// Submission ID: 1581993121
// Language: java
// Timestamp (UTC): 2025-03-22T06:12:48Z

class Solution {

    int vertex;
	 int edgeNumbers;
	 
   public int countCompleteComponents(int n, int[][] edges) {
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
	int output = 0;
	for(int i = 0; i<n; i++) {
		if(!visited[i]) {
			vertex = 0;
			edgeNumbers = 0;
			dfs(graph,visited,i);
			
			if(isConnected(vertex,edgeNumbers/2)) output++;
		}
	}
	
	return output;
    }

	private boolean isConnected(int vertex2, int i) {
	// TODO Auto-generated method stub
		return i == vertex2*(vertex2-1)/2;
}

	private void dfs(ArrayList<ArrayList<Integer>> graph, boolean[] visited, int i) {
	vertex++;
	visited[i] = true;
	
	edgeNumbers+=graph.get(i).size();
	
	for(int nbrs : graph.get(i)) {
		if(!visited[nbrs]) {
			dfs(graph, visited, nbrs);
		}
	}
	
}
}