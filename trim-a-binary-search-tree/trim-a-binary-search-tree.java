// LeetCode: Trim a Binary Search Tree (trim-a-binary-search-tree)
// Submission ID: 1651649473
// Language: java
// Timestamp (UTC): 2025-06-02T12:10:20Z

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
    public static TreeNode solution(TreeNode root, int low, int high){
        if(root == null) return root;
        
        if(root.val<low)return solution(root.right,low,high);
        if(root.val>high)return solution(root.left,low,high);
        
        root.left = solution(root.left,low,high);
        root.right = solution(root.right,low,high);
        
        return root;
    }
    public TreeNode trimBST(TreeNode root, int low, int high) {
        
        
        return solution(root,low,high);
    }
}