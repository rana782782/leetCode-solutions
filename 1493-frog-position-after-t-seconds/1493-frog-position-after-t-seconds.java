class Solution {
    static class Pair {
        int vertex;
        double prob;

        Pair(int vertex, double prob) {
            this.vertex = vertex;
            this.prob = prob;
        }
    }

    public double frogPosition(int n, int[][] edges, int t, int target) {
        // Build adjacency list
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());
        for (int[] e : edges) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }

        boolean[] visited = new boolean[n + 1];
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(1, 1.0));
        visited[1] = true;

        int time = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Pair curr = q.poll();

               
                if (curr.vertex == target) {
                   
                    if (time == t || getUnvisitedCount(graph, curr.vertex, visited) == 0)
                        return curr.prob;
                    else
                        return 0.0;
                }

                int unvisited = getUnvisitedCount(graph, curr.vertex, visited);
                if (unvisited == 0) continue;

                double nextProb = curr.prob / unvisited;
                for (int nei : graph.get(curr.vertex)) {
                    if (!visited[nei]) {
                        visited[nei] = true;
                        q.add(new Pair(nei, nextProb));
                    }
                }
            }

            time++;
            if (time > t) break;
        }

        return 0.0;
    }

    private int getUnvisitedCount(List<List<Integer>> graph, int node, boolean[] visited) {
        int count = 0;
        for (int nei : graph.get(node)) if (!visited[nei]) count++;
        return count;
    }
}
