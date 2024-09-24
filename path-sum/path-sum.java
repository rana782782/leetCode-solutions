// LeetCode: Path Sum (path-sum)
// Submission ID: 1400882934
// Language: java
// Timestamp (UTC): 2024-09-24T15:58:24Z

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
    public static boolean solution(TreeNode root, int target){
        if(root == null){
            return false;
        }

        if(root.left == null && root.right == null && root.val == target){
                  return true;
        }

        boolean leftOne = solution(root.left,target-root.val);
        boolean rightOne = solution(root.right,target-root.val);

        return leftOne||rightOne;
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
         boolean ans = solution(root,targetSum);
         return ans;
    }
}