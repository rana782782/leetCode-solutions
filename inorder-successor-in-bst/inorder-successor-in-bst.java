// LeetCode: Inorder Successor in BST (inorder-successor-in-bst)
// Submission ID: 1716894341
// Language: java
// Timestamp (UTC): 2025-07-30T09:31:45Z

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    static TreeNode output;
    public static void solution(TreeNode root, int target){
        if(root == null)return;

        if(root.val>target){
            output = root;
            solution(root.left,target);
        }
        else{
            solution(root.right,target);
        }
    }
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        output = null;
        solution(root,p.val);
        return output;
    }
}