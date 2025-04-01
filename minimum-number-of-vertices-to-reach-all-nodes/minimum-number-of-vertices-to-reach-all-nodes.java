// LeetCode: Minimum Number of Vertices to Reach All Nodes (minimum-number-of-vertices-to-reach-all-nodes)
// Submission ID: 1593132471
// Language: java
// Timestamp (UTC): 2025-04-01T13:16:16Z

class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int vertex[] = new int[n];
        Arrays.fill(vertex,0);

        for(List<Integer> e : edges){
            vertex[e.get(1)]++;
        }

        List<Integer>output = new ArrayList<>();
        for(int i = 0; i<vertex.length; i++){
            if(vertex[i] == 0)output.add(i);
        }

        return output;
    }
}