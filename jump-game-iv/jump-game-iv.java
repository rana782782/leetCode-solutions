// LeetCode: Jump Game IV (jump-game-iv)
// Submission ID: 1499629366
// Language: java
// Timestamp (UTC): 2025-01-06T14:44:09Z

class Solution {
   	
	 public int minJumps(int[] arr) {
        if (arr.length == 1) return 0; // If there's only one element, no jumps are needed

        // Create a map of values to their indices
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.computeIfAbsent(arr[i], x -> new ArrayList<>()).add(i);
        }

        // BFS variables
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[arr.length];
        queue.add(0);
        visited[0] = true;

        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int idx = queue.poll();

                // If we've reached the last index
                if (idx == arr.length - 1) return steps;

                // Add neighbors: previous and next indices
                if (idx - 1 >= 0 && !visited[idx - 1]) {
                    queue.add(idx - 1);
                    visited[idx - 1] = true;
                }
                if (idx + 1 < arr.length && !visited[idx + 1]) {
                    queue.add(idx + 1);
                    visited[idx + 1] = true;
                }

                // Add all indices with the same value
                if (map.containsKey(arr[idx])) {
                    for (int neighbor : map.get(arr[idx])) {
                        if (!visited[neighbor]) {
                            queue.add(neighbor);
                            visited[neighbor] = true;
                        }
                    }
                    // Clear the list to avoid redundant processing
                    map.remove(arr[idx]);
                }
            }
            steps++;
        }

        return -1; // If we exhaust the queue without reaching the last index
    }
}