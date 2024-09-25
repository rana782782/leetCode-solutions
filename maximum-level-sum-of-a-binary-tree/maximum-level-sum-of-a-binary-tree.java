// LeetCode: Maximum Level Sum of a Binary Tree (maximum-level-sum-of-a-binary-tree)
// Submission ID: 1402090767
// Language: java
// Timestamp (UTC): 2024-09-25T17:18:31Z

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
    public int maxLevelSum(TreeNode root) {

       
        int maxSum = Integer.MIN_VALUE;
        int level = 0;
        int k = 1;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();
            int sum = 0;
            while(size--!=0){
                TreeNode rem = q.poll();
                sum+=rem.val;
                if(rem.left!=null){
                    q.add(rem.left);
                }

                if(rem.right!=null){
                    q.add(rem.right);
                }
            }
            if(sum>maxSum){
                maxSum = sum;
                level = k;
            }
            k++;
        }
        return level;
    }
}