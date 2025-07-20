// LeetCode: Course Schedule (course-schedule)
// Submission ID: 1704732946
// Language: java
// Timestamp (UTC): 2025-07-20T12:22:28Z

class Solution {
    public static boolean solution(int vertex, ArrayList<ArrayList<Integer>> graph, boolean[] visited, boolean[] pathVisited) {
        visited[vertex] = true;
        pathVisited[vertex] = true;

        for (int nbrs : graph.get(vertex)) {
            if (!visited[nbrs]) {
                if (solution(nbrs, graph, visited, pathVisited)) return true;
            } else if (pathVisited[nbrs]) {
                return true;
            }
        }

        pathVisited[vertex] = false;
        return false;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] d : prerequisites) {
            int src = d[0];
            int dest = d[1];
            graph.get(src).add(dest);
        }

        boolean[] visited = new boolean[numCourses];
        boolean[] pathVisited = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                if (solution(i, graph, visited, pathVisited)) return false;
            }
        }

        return true;
    }
}
