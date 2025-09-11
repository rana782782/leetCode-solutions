// LeetCode: Construct Binary Tree from Preorder and Postorder Traversal (construct-binary-tree-from-preorder-and-postorder-traversal)
// Submission ID: 1767037881
// Language: java
// Timestamp (UTC): 2025-09-11T10:15:49Z

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

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return build(preorder, 0, preorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private static TreeNode build(int[] pre, int psi, int pei, int[] post, int posi, int poei) {
        if (psi > pei) return null;

        TreeNode root = new TreeNode(pre[psi]);
        if (psi == pei) return root; // Single node case

        // Find left subtree root index in preorder
        int leftRootVal = pre[psi + 1];
        int idx = posi;
        while (post[idx] != leftRootVal) idx++;

        int leftSubtreeSize = idx - posi + 1;

        root.left = build(pre, psi + 1, psi + leftSubtreeSize, post, posi, idx);
        root.right = build(pre, psi + leftSubtreeSize + 1, pei, post, idx + 1, poei - 1);

        return root;
    }
}