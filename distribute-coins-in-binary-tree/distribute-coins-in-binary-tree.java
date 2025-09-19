// LeetCode: Distribute Coins in Binary Tree (distribute-coins-in-binary-tree)
// Submission ID: 1776122166
// Language: java
// Timestamp (UTC): 2025-09-19T14:13:51Z

class Solution {
    private int moves = 0;

    
    private int dfs(TreeNode node) {
        if (node == null) return 0;
        int left = dfs(node.left);
        int right = dfs(node.right);
        moves += Math.abs(left) + Math.abs(right);
        return node.val + left + right - 1; 
    }

    public int distributeCoins(TreeNode root) {
        moves = 0;
        dfs(root);
        return moves;
    }
}