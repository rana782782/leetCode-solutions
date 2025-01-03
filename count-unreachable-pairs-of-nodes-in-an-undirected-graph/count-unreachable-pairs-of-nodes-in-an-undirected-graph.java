// LeetCode: Count Unreachable Pairs of Nodes in an Undirected Graph (count-unreachable-pairs-of-nodes-in-an-undirected-graph)
// Submission ID: 1496151498
// Language: java
// Timestamp (UTC): 2025-01-03T10:49:16Z

class Solution {
    public long countPairs(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        
        for(int i = 0; i<n; i++) {
        	graph.add(new ArrayList<>());
        }
        
        for(int arr[]: edges) {
        	int u = arr[0];
        	 int v = arr[1];
        	 
        	 graph.get(u).add(v);
        	 graph.get(v).add(u);
        }
        
        boolean visited[] = new boolean[n];
        
        ArrayList<Integer> compSizes = new ArrayList<>();
        for(int i = 0; i<n; i++) {
        	
        	if(!visited[i]) {
        		ans = 0;
        		dfs(i,graph,visited);
                System.out.println(ans);
        		compSizes.add(ans);
        	}
        }
        
    
           long totalPairs = (long) n * (n - 1) / 2; // Total possible pairs
        long reachablePairs = 0;

        for (int size : compSizes) {
            reachablePairs += (long) size * (size - 1) / 2; // Pairs within a component
        }

        return totalPairs - reachablePairs;
    
        
        
    }
static int ans;
	private void dfs(int i, ArrayList<ArrayList<Integer>> graph, boolean[] visited) {
	// TODO Auto-generated method stub
		visited[i] = true;
		ans++;
		
		for(int nbr : graph.get(i)) {
			if(!visited[nbr]) {
				dfs(nbr, graph, visited);
			}
		}
	
}
}