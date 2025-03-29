// LeetCode: Longest Path With Different Adjacent Characters (longest-path-with-different-adjacent-characters)
// Submission ID: 1589928263
// Language: java
// Timestamp (UTC): 2025-03-29T10:26:17Z

class Solution {
  static int output;

    public static int dfs(int vertex, ArrayList<ArrayList<Integer>> graph, int parent, char arr[]) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int nbr : graph.get(vertex)) {
            if (nbr != parent) {  // Allow traversal to all children
                int subPath = dfs(nbr, graph, vertex, arr);
                if (arr[nbr] != arr[vertex]) {  // Consider only valid character transitions
                    pq.add(subPath);
                }
            }
        }

        int first = pq.isEmpty() ? 0 : pq.poll();
        int second = pq.isEmpty() ? 0 : pq.poll();

        output = Math.max(output, first + second + 1);

        return 1 + first;
    }

    public static int longestPath(int[] parent, String s) {
        int n = parent.length;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 1; i < n; i++) {
            graph.get(i).add(parent[i]);
            graph.get(parent[i]).add(i);
        }

        output = 0;
        dfs(0, graph, -1, s.toCharArray());

        return output;
    }
}