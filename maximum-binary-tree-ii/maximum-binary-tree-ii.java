// LeetCode: Maximum Binary Tree II (maximum-binary-tree-ii)
// Submission ID: 1647431054
// Language: java
// Timestamp (UTC): 2025-05-28T22:09:12Z

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
    public static void getInOrder(TreeNode root, List<Integer>subAns){
        if(root == null)return;

        getInOrder(root.left,subAns);
        subAns.add(root.val);
        getInOrder(root.right,subAns);
    }
    public static int getMaxIdx(int si, int ei, int nums[]){
        int idx = 0;

        int currMax = Integer.MIN_VALUE;

        for(int i = si; i<=ei; i++){
            if(nums[i]>currMax){
                currMax = nums[i];
                idx = i;
            }
        }

        return idx;
    }

    public static TreeNode solution(int si, int ei, int nums[]){
        if(si>ei || ei<si)return null;

        if(si == ei){
            TreeNode root = new TreeNode(nums[si]);
            return root;
        }

        int maxIdx = getMaxIdx(si, ei, nums);

        TreeNode root = new TreeNode(nums[maxIdx]);
        root.left = solution(si,maxIdx-1,nums);
        root.right = solution(maxIdx+1,ei,nums);
        return root;
    }

   
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        List<Integer>inOrder = new ArrayList<>();

        getInOrder(root,inOrder);
        inOrder.add(val);

        int n = inOrder.size();

        int nums[] = new int[n];
            int idx =0;
        for(int ele : inOrder){
                nums[idx++] = ele;
        }


return solution(0,n-1,nums);


    }
}