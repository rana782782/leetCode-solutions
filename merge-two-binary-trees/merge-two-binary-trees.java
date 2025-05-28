// LeetCode: Merge Two Binary Trees (merge-two-binary-trees)
// Submission ID: 1647435354
// Language: java
// Timestamp (UTC): 2025-05-28T22:20:24Z

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
    public static TreeNode solution(TreeNode root1,TreeNode root2){
        if(root1 == null && root2 == null)return null;
        if(root1 == null && root2!=null)return root2;
        if(root1!=null && root2 == null)return root1;

        int val1 = root1.val;
        int val2 = root2.val;

        TreeNode root = new TreeNode(val1+val2);

        root.left = solution(root1.left,root2.left);
        root.right = solution(root1.right,root2.right);

        return root;
    }
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        return solution(root1,root2);
    }
}