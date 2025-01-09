// LeetCode: Similar String Groups (similar-string-groups)
// Submission ID: 1502838945
// Language: java
// Timestamp (UTC): 2025-01-09T10:13:59Z

class Solution {
   public static int find(int parent[], int x) {
    if (parent[x] == x) return x;
    return parent[x] = find(parent, parent[x]); // Path compression
}

public static void union(int parent[], int rank[], int x, int y) {
    int lx = find(parent, x);
    int ly = find(parent, y);

    if (lx != ly) {
        if (rank[lx] > rank[ly]) {
            parent[ly] = lx;
        } else if (rank[ly] > rank[lx]) {
            parent[lx] = ly;
        } else {
            parent[ly] = lx;
            rank[lx]++;
        }
    }
}

public static boolean isSimilar(String s1, String s2) {
    if (s1.length() != s2.length()) return false;
    int diff = 0;
    for (int i = 0; i < s1.length(); i++) {
        if (s1.charAt(i) != s2.charAt(i)) diff++;
    }
    return diff == 0 || diff == 2;
}

public int numSimilarGroups(String[] strs) {
    int size = strs.length;
    int parent[] = new int[size];
    int rank[] = new int[size];

    // Initialize Union-Find structures
    for (int i = 0; i < size; i++) {
        parent[i] = i;
        rank[i] = 1;
    }

    // Perform union for similar strings
    for (int i = 0; i < size - 1; i++) {
        for (int j = i + 1; j < size; j++) {
            if (isSimilar(strs[i], strs[j])) {
                union(parent, rank, i, j);
            }
        }
    }

    // Path compression for all nodes
    for (int i = 0; i < size; i++) {
        find(parent, i);
    }

    // Count unique groups
    HashSet<Integer> grp = new HashSet<>();
    for (int i = 0; i < size; i++) {
        grp.add(parent[i]);
    }

    return grp.size();
}


}