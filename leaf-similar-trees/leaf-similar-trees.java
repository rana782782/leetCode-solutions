// LeetCode: Leaf-Similar Trees (leaf-similar-trees)
// Submission ID: 1651695734
// Language: java
// Timestamp (UTC): 2025-06-02T13:11:21Z

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
    public static void getLeaf(TreeNode root,List<Integer>leafs){
        if(root == null)return;
        
        if(root.left == null && root.right == null){
            leafs.add(root.val);
            return;
        }
        
        getLeaf(root.left,leafs);
        getLeaf(root.right,leafs);
    }
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer>l1 = new ArrayList<>();
        List<Integer>l2 = new ArrayList<>();
        
        getLeaf(root1,l1);
        getLeaf(root2,l2);
        
        System.out.println(l1);
        System.out.println(l2);
        
        return l1.equals(l2);
    }
}