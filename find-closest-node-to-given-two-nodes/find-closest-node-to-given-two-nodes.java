// LeetCode: Find Closest Node to Given Two Nodes (find-closest-node-to-given-two-nodes)
// Submission ID: 1592074157
// Language: java
// Timestamp (UTC): 2025-03-31T13:37:28Z

import java.util.*;

class Solution {
    public static class Pair {
        int vertex;
        int price;

        Pair(int vertex, int price) {
            this.vertex = vertex;
            this.price = price;
        }
    }

    static int n;

    public static int[] bfs(int edges[], int start) {
        int cost[] = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[start] = 0;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(start, 0));

        while (!q.isEmpty()) {
            Pair rem = q.poll();

            if (edges[rem.vertex] != -1) {
                int nbrs = edges[rem.vertex];
                if (rem.price + 1 < cost[nbrs]) {
                    cost[nbrs] = rem.price + 1;
                    q.add(new Pair(nbrs, cost[nbrs]));
                }
            }
        }
        return cost;
    }

    public int closestMeetingNode(int[] edges, int node1, int node2) {
        n = edges.length;

        int cost1[] = bfs(edges, node1);
        int cost2[] = bfs(edges, node2);

        int idx = -1;
        int minima = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (cost1[i] != Integer.MAX_VALUE && cost2[i] != Integer.MAX_VALUE) {
                int maxDist = Math.max(cost1[i], cost2[i]);
                if (maxDist < minima) {
                    minima = maxDist;
                    idx = i;
                }
            }
        }

        return idx;
    }
}
