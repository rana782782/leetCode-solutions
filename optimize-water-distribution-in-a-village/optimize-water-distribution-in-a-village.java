// LeetCode: Optimize Water Distribution in a Village (optimize-water-distribution-in-a-village)
// Submission ID: 1644919188
// Language: java
// Timestamp (UTC): 2025-05-26T11:30:05Z

class Solution {
    public static class Pair implements Comparable<Pair> {
        int src, dest, cost;
        Pair(int src, int dest, int cost) {
            this.src = src;
            this.dest = dest;
            this.cost = cost;
        }

        public int compareTo(Pair o) {
            return this.cost - o.cost;
        }
    }

    static int[] parent;
    static int[] rank;

    public static int find(int x) {
        if (parent[x] != x)
            parent[x] = find(parent[x]);
        return parent[x];
    }

    public static boolean union(int x, int y) {
        int lx = find(x);
        int ly = find(y);

        if (lx != ly) {
            if (rank[lx] > rank[ly]) {
                parent[ly] = lx;
            } else if (rank[ly] > rank[lx]) {
                parent[lx] = ly;
            } else {
                parent[lx] = ly;
                rank[ly]++;
            }
            return true;
        }

        return false;
    }

    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        parent = new int[n + 1];
        rank = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }

        List<Pair> conn = new ArrayList<>();

        // Add virtual edges from node 0 to each house
        for (int i = 1; i <= n; i++) {
            conn.add(new Pair(0, i, wells[i - 1]));
        }

        // Add given pipes
        for (int[] p : pipes) {
            conn.add(new Pair(p[0], p[1], p[2]));
        }

        Collections.sort(conn);

        int totalCost = 0;
        int count = 0;

        for (Pair p : conn) {
            if (union(p.src, p.dest)) {
                totalCost += p.cost;
                count++;
                if (count == n) break; // n edges for n+1 nodes (0 to n)
            }
        }

        return totalCost;
    }
}
