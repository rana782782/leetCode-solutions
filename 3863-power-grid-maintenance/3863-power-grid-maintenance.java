import java.util.*;

class Solution {
    static int[] parent;
    static int[] rank;

    static int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }

    static void union(int x, int y) {
        int rx = find(x), ry = find(y);
        if (rx == ry) return;
        if (rank[rx] < rank[ry]) {
            parent[rx] = ry;
        } else if (rank[ry] < rank[rx]) {
            parent[ry] = rx;
        } else {
            parent[ry] = rx;
            rank[rx]++; 
        }
    }

    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        parent = new int[c + 1];
        rank = new int[c + 1];
        for (int i = 1; i <= c; i++) {
            parent[i] = i;
            rank[i] = 1;
        }

        for (int[] e : connections) union(e[0], e[1]);

      
        Map<Integer, TreeSet<Integer>> comp = new HashMap<>();
        for (int i = 1; i <= c; i++) {
            int r = find(i);
            comp.computeIfAbsent(r, k -> new TreeSet<>()).add(i);
        }

        List<Integer> out = new ArrayList<>();
        for (int[] q : queries) {
            int type = q[0], y = q[1];
            int r = find(y);
            TreeSet<Integer> set = comp.get(r);

            if (type == 1) {
                if (set == null || set.isEmpty()) {
                    out.add(-1);
                } else if (set.contains(y)) {
                    out.add(y);
                } else {
                    out.add(set.first());
                }
            } else { 
                if (set != null) set.remove(y);
            }
        }

        
        int[] ans = new int[out.size()];
        for (int i = 0; i < ans.length; i++) ans[i] = out.get(i);
        return ans;
    }
}
