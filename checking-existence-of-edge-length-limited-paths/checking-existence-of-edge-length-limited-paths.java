// LeetCode: Checking Existence of Edge Length Limited Paths (checking-existence-of-edge-length-limited-paths)
// Submission ID: 1500682851
// Language: java
// Timestamp (UTC): 2025-01-07T13:00:17Z

class Solution {
   public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
    // Initialize parent and rank arrays for Union-Find
    int[] parent = new int[n];
    int[] rank = new int[n];
    for (int i = 0; i < n; i++) {
        parent[i] = i;
        rank[i] = 1;
    }

    // Add query index to each query
    int len = queries.length;
    int[][] nayaQueries = new int[len][4];
    for (int i = 0; i < len; i++) {
        nayaQueries[i][0] = queries[i][0];
        nayaQueries[i][1] = queries[i][1];
        nayaQueries[i][2] = queries[i][2];
        nayaQueries[i][3] = i; // Store original index
    }

    // Sort queries by limit
    Arrays.sort(nayaQueries, (a, b) -> Integer.compare(a[2], b[2]));

    // Sort edges by weight
    Arrays.sort(edgeList, (a, b) -> Integer.compare(a[2], b[2]));

    boolean[] output = new boolean[len];
    int edgeIndex = 0;

    // Process each query
    for (int[] query : nayaQueries) {
        int u = query[0];
        int v = query[1];
        int limit = query[2];
        int idx = query[3];

        // Union edges with weights less than the current limit
        while (edgeIndex < edgeList.length && edgeList[edgeIndex][2] < limit) {
            int x = edgeList[edgeIndex][0];
            int y = edgeList[edgeIndex][1];
            union(parent, x, y, rank);
            edgeIndex++;
        }

        // Check if u and v are connected
        if (find(parent, u) == find(parent, v)) {
            output[idx] = true;
        }
    }

    return output;
}

// Union-Find helper functions
public static int find(int[] parent, int x) {
    if (parent[x] == x) return x;
    return parent[x] = find(parent, parent[x]); // Path compression
}

public static void union(int[] parent, int x, int y, int[] rank) {
    int lx = find(parent, x);
    int ly = find(parent, y);

    if (lx != ly) {
        if (rank[lx] > rank[ly]) {
            parent[ly] = lx;
        } else if (rank[ly] > rank[lx]) {
            parent[lx] = ly;
        } else {
            parent[lx] = ly;
            rank[ly]++;
        }
    }
}
}