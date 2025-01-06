// LeetCode: Jump Game III (jump-game-iii)
// Submission ID: 1499561794
// Language: java
// Timestamp (UTC): 2025-01-06T13:30:01Z

class Solution {
  public boolean canReach(int[] arr, int start) {
    if (arr == null || arr.length == 0 || start < 0 || start >= arr.length) {
        return false; // Handle edge cases for invalid input
    }

    HashSet<Integer> visited = new HashSet<>();
    Queue<Integer> q = new LinkedList<>();
    q.add(start);

    while (!q.isEmpty()) {
        int idx = q.poll();

        // Check if we've reached a zero
        if (arr[idx] == 0) {
            return true;
        }

        // Mark the current index as visited
        if (visited.contains(idx)) {
            continue;
        }
        visited.add(idx);

        // Add neighbors to the queue if valid
        int fwd = idx + arr[idx];
        int bwd = idx - arr[idx];

        if (fwd >= 0 && fwd < arr.length && !visited.contains(fwd)) {
            q.add(fwd);
        }
        if (bwd >= 0 && bwd < arr.length && !visited.contains(bwd)) {
            q.add(bwd);
        }
    }

    return false; // If we exhaust the queue without finding a zero
}

}