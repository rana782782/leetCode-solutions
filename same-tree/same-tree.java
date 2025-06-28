// LeetCode: Same Tree (same-tree)
// Submission ID: 1679266534
// Language: java
// Timestamp (UTC): 2025-06-28T12:08:23Z

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
    public static boolean solution(TreeNode root1, TreeNode root2){
        if(root1 == null && root2 == null)return true;
        
        if(root1 == null || root2 == null)return false;
        
        if(root1.val!=root2.val)return false;
        
        return solution(root1.left,root2.left) && solution(root1.right,root2.right);
        
        
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        
        return solution(p,q);
    }
}