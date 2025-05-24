// LeetCode: Count Univalue Subtrees (count-univalue-subtrees)
// Submission ID: 1642970963
// Language: java
// Timestamp (UTC): 2025-05-24T12:00:30Z

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
    public static boolean isSame(TreeNode root, int target){
        if(root.left == null && root.right == null && root.val == target)return true;

        boolean ansLeft = true;
        boolean ansRight = true;

        if(root.left!=null){
            if(root.left.val == target){
                ansLeft = isSame(root.left,target);
            }
            else{
                return false;
            }
        }

        if(root.right!=null){
            if(root.right.val == target){
                ansRight = isSame(root.right,target);
            }
            else{
                return false;
            }
        }

        return ansLeft&&ansRight;
    }

    static int output;

    public static void dfs(TreeNode root){
        if(root == null)return;

        if(isSame(root,root.val))output++;

        dfs(root.left);
        dfs(root.right);
    }
    public int countUnivalSubtrees(TreeNode root) {
       output = 0;
       dfs(root);
       return output; 
    }
}