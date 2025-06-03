// LeetCode: All Paths From Source to Target (all-paths-from-source-to-target)
// Submission ID: 1653011179
// Language: java
// Timestamp (UTC): 2025-06-03T18:52:40Z

class Solution {
    static List<List<Integer>>output;
    static int n;
    static boolean visited[];
    public static void solution(int vertex, int graph[][],List<Integer>subAns){
        if(vertex == n-1){
            if(subAns.size()!=0)output.add(new ArrayList<>(subAns));
            
            return;
        }
        
        visited[vertex] = true;
        
        for(int nbrs : graph[vertex]){
            if(!visited[nbrs]){
                subAns.add(nbrs);
                solution(nbrs,graph,subAns);
                subAns.remove(subAns.size()-1);
            }
        }
        visited[vertex] = false;
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        output = new ArrayList<>();
        n = graph.length;
        visited = new boolean[n];
        
        List<Integer>subAns = new ArrayList<>();
        subAns.add(0);
        
        solution(0,graph,subAns);
        
        return output;
    }
}