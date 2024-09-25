// LeetCode: Path Sum II (path-sum-ii)
// Submission ID: 1401783017
// Language: java
// Timestamp (UTC): 2024-09-25T11:48:11Z

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
    List<List<Integer>> result=new ArrayList<List<Integer>>();

      public void target(TreeNode root,int targetSum,ArrayList<Integer> list){
        
        if(root==null){
            return;
        }
        if(root.left==null && root.right==null && targetSum==root.val){
            list.add(root.val);
            result.add(new ArrayList<>(list));
            list.remove(list.size()-1);
        }
        list.add(root.val);
        target(root.left,targetSum-root.val,list);
        target(root.right,targetSum-root.val,list);
        list.remove(list.size()-1);
    }

    
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        target(root,targetSum,new ArrayList<>());
        return result;
    }
  
}