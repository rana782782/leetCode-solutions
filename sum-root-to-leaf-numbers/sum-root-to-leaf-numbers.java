// LeetCode: Sum Root to Leaf Numbers (sum-root-to-leaf-numbers)
// Submission ID: 1400791779
// Language: java
// Timestamp (UTC): 2024-09-24T14:32:57Z

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
    public static void solution(TreeNode root, int ans, List<Integer>output){
        if(root == null){
            return;
        }

        if(root.left == null && root.right == null){
            ans = ans*10+root.val;
            output.add(ans);
            return;
        }
        ans = ans*10+root.val;

        solution(root.left,ans,output);
        solution(root.right,ans,output);
    }
    public int sumNumbers(TreeNode root) {
        List<Integer> output = new ArrayList<>();
        solution(root,0,output);
      int ans = 0;
      for(int i : output){
        ans+=i;
      }
      return ans;
    }
}