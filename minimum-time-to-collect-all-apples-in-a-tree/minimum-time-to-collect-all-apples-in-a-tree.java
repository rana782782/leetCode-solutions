// LeetCode: Minimum Time to Collect All Apples in a Tree (minimum-time-to-collect-all-apples-in-a-tree)
// Submission ID: 1589515418
// Language: java
// Timestamp (UTC): 2025-03-28T20:57:36Z

class Solution {

    public static int dfs(ArrayList<ArrayList<Integer>> graph, int src, int parent,List<Boolean>hasApple){
        int time = 0;

        for(int nbrs : graph.get(src)){
            if(nbrs!=parent){
                int timeTaken = dfs(graph,nbrs,src,hasApple);

                if(timeTaken>0 || hasApple.get(nbrs) ==  true)time+=timeTaken+2;
            }
        }

        return time;
    }
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for(int i = 0; i<n; i++){
            graph.add(new ArrayList<>());
        }

        for(int e[] : edges){
            int u = e[0];
             int v = e[1];

             graph.get(u).add(v);
             graph.get(v).add(u);
        }

        return dfs(graph,0,-1,hasApple);
    }
}