// LeetCode: Binary Tree Inorder Traversal (binary-tree-inorder-traversal)
// Submission ID: 1652033739
// Language: java
// Timestamp (UTC): 2025-06-02T19:02:45Z

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
    public static void solution(TreeNode root,List<Integer>output){
        if(root == null)return;
        
        solution(root.left,output);
        output.add(root.val);
        solution(root.right,output);
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer>output = new ArrayList<>();
        solution(root,output);
        return output;
        
    }
}