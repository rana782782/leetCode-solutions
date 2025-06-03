// LeetCode: Find All The Lonely Nodes (find-all-the-lonely-nodes)
// Submission ID: 1653111846
// Language: java
// Timestamp (UTC): 2025-06-03T21:47:21Z

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
    static List<Integer>output;
    
    public static void solution(TreeNode root){
        if(root == null)return;
        
        if(root.left == null && root.right!=null){
            output.add(root.right.val);
        }
        else if(root.left!=null && root.right == null){
            output.add(root.left.val);
        }
        
        solution(root.left);
        solution(root.right);
    }
    public List<Integer> getLonelyNodes(TreeNode root) {
        output = new ArrayList<>();
        solution(root);
        
        return output;
    }
}