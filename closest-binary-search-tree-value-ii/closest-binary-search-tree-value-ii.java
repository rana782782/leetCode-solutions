// LeetCode: Closest Binary Search Tree Value II (closest-binary-search-tree-value-ii)
// Submission ID: 1643042289
// Language: java
// Timestamp (UTC): 2025-05-24T13:43:06Z

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public static class Pair implements Comparable<Pair> {
        int num;
        Double diff;

        Pair(Double diff, int num) {
            this.diff = diff;
            this.num = num;
        }

        @Override
        public int compareTo(Pair o) {
            int cmp = Double.compare(this.diff, o.diff); // ascending
            if (cmp != 0) return cmp;
            return Integer.compare(this.num, o.num);
        }
    }

    static PriorityQueue<Pair> pq;
    static int K;

    public static void insert(Pair curr) {
        if (pq.isEmpty() || pq.size() < K) {
            pq.add(curr);
        } else {
            if (pq.peek().diff > curr.diff) {
                pq.poll();
                pq.add(curr);
            } else if (pq.peek().diff.equals(curr.diff) && pq.peek().num > curr.num) {
                pq.poll();
                pq.add(curr);
            }
        }
    }

    public static void dfs(TreeNode root, double target) {
        if (root == null) return;

        Double currDiff = Math.abs(target - root.val);
        Pair currPair = new Pair(currDiff, root.val);
        insert(currPair);

        dfs(root.left, target);
        dfs(root.right, target);
    }

    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        pq = new PriorityQueue<>(Collections.reverseOrder());
        K = k;
        dfs(root, target);

        List<Integer> output = new ArrayList<>();
        while (!pq.isEmpty()) {
            output.add(pq.poll().num);
        }

        return output;
    }
}
