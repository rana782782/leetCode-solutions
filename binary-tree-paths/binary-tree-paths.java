// LeetCode: Binary Tree Paths (binary-tree-paths)
// Submission ID: 1400743184
// Language: java
// Timestamp (UTC): 2024-09-24T13:45:21Z

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

    public static void solution(TreeNode root,String psf,List<String>output){
        if(root == null){
            return;
        }

        if(root.left == null && root.right == null){
            psf+=root.val;
            System.out.println(psf);
            output.add(psf);
            return;
        }

        solution(root.left,psf+root.val+"->",output);
        solution(root.right,psf+root.val+"->",output);
    }
    public List<String> binaryTreePaths(TreeNode root) {
        List<String>ans = new ArrayList<>();
        solution(root,"",ans);
        return ans;
    }
}