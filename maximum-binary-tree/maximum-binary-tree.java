// LeetCode: Maximum Binary Tree (maximum-binary-tree)
// Submission ID: 1691401182
// Language: java
// Timestamp (UTC): 2025-07-09T01:30:23Z

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
    public static int getMax(int start, int end, int nums[]){
        int maxEle = -1;
        int idx = -1;
        
        for(int i = start; i<=end; i++){
            if(nums[i]>maxEle){
                maxEle = nums[i];
                idx = i;
            }
        }
        
        return idx;
    }
    
    public static TreeNode solution(int si, int ei,int nums[]){
        if(si>ei)return null;
        
        int maxIdx = getMax(si,ei,nums);
        
        TreeNode root = new TreeNode(nums[maxIdx]);
        root.left = solution(si,maxIdx-1,nums);
        root.right = solution(maxIdx+1,ei,nums);
        
        return root;
    }
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        
        return solution(0,nums.length-1,nums);
    }
}