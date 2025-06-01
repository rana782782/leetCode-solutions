// LeetCode: Insert into a Binary Search Tree (insert-into-a-binary-search-tree)
// Submission ID: 1651055719
// Language: java
// Timestamp (UTC): 2025-06-01T20:00:04Z

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
    
    public static TreeNode solution(TreeNode root, int val){
        if(root == null)return new TreeNode(val);
        
        if(root.val<val){
            root.right = solution(root.right,val);
        }
        else{
            root.left = solution(root.left,val);
        }
        
        return root;
    }
    public TreeNode insertIntoBST(TreeNode root, int val) {
        
        
        return solution(root,val);
    }
}