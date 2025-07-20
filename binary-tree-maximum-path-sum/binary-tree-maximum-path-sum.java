// LeetCode: Binary Tree Maximum Path Sum (binary-tree-maximum-path-sum)
// Submission ID: 1704709386
// Language: java
// Timestamp (UTC): 2025-07-20T11:55:20Z

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
    static int output;
    public static int solution(TreeNode root){
        if(root == null)return 0;
        
        int ls = solution(root.left);
        int rs = solution(root.right);
        
     output = Math.max(Math.max(root.val+ls,root.val+rs),Math.max(output,root.val+ls+rs));
        output = Math.max(output,root.val);
        
        return Math.max(root.val,root.val+Math.max(ls,rs));
    }
    public int maxPathSum(TreeNode root) {
        
        output = Integer.MIN_VALUE;
        
        solution(root);
        return output;
        
    }
}