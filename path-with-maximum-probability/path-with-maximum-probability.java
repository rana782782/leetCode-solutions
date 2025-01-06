// LeetCode: Path with Maximum Probability (path-with-maximum-probability)
// Submission ID: 1499895035
// Language: java
// Timestamp (UTC): 2025-01-06T18:54:26Z

class Solution {
  public class Pair implements Comparable<Pair> {
        int dest;
        double cost;

        Pair(int dest, double cost) {
            this.dest = dest;
            this.cost = cost;
        }

        public int compareTo(Pair o) {
            return Double.compare(this.cost, o.cost);
        }
    }

    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        // Build the graph
        ArrayList<ArrayList<Pair>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            graph.get(u).add(new Pair(v, succProb[i]));
            graph.get(v).add(new Pair(u, succProb[i]));
        }

        // Priority queue for Dijkstra's-like traversal (max-heap)
        PriorityQueue<Pair> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.add(new Pair(start_node, 1.0));

        // Probability array to track the maximum probability to reach each node
        double[] maxProb = new double[n];
        maxProb[start_node] = 1.0;

        while (!pq.isEmpty()) {
            Pair rem = pq.poll();

            // If we reach the end node, return the max probability
            if (rem.dest == end_node) {
                return rem.cost;
            }

            // Traverse neighbors
            for (Pair neighbor : graph.get(rem.dest)) {
                double newProb = rem.cost * neighbor.cost;

                if (newProb > maxProb[neighbor.dest]) {
                    maxProb[neighbor.dest] = newProb;
                    pq.add(new Pair(neighbor.dest, newProb));
                }
            }
        }

        // If the end node is not reachable, return 0
        return 0.0;
    }
}