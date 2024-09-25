// LeetCode: Binary Tree Level Order Traversal II (binary-tree-level-order-traversal-ii)
// Submission ID: 1402027012
// Language: java
// Timestamp (UTC): 2024-09-25T16:21:45Z

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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        if(root == null){
            return new ArrayList<>();
        }
        List<List<Integer>> output = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> subAns = new ArrayList<>();

            while(size--!=0){
                TreeNode rem = q.poll();
                subAns.add(rem.val);

                if(rem.left!=null){
                    q.add(rem.left);
                }

                if(rem.right!=null){
                    q.add(rem.right);
                }
            }
            output.add(subAns);
        }
        Collections.reverse(output);
        return output;
    }
}