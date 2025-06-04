// LeetCode: Binary Search Tree to Greater Sum Tree (binary-search-tree-to-greater-sum-tree)
// Submission ID: 1654108651
// Language: java
// Timestamp (UTC): 2025-06-04T19:59:31Z

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
    public static void solution(TreeNode root, List<Integer>subAns){
        if(root == null)return;
        
        
        
        solution(root.left,subAns);
         subAns.add(root.val);
        solution(root.right,subAns);
    }
    
    static HashMap<Integer,Integer>map;
    static int res[];
    static int sum;
    
    public static TreeNode get(TreeNode root){
        if(root == null)return null;
        
        int ele = root.val;
        
        int idx = map.get(ele);
        
        TreeNode currNode = new TreeNode(idx>0 ? sum-res[idx-1] : sum);
        
        currNode.left = get(root.left);
        currNode.right = get(root.right);
        
        return currNode;
        
        
    }
    public TreeNode bstToGst(TreeNode root) {
        List<Integer>output = new ArrayList<>();
          solution(root,output);
        map = new HashMap<>();
        
        for(int i = 0; i<output.size(); i++){
                    map.put(output.get(i),i);
        }
        
        sum = 0;
        
        res = new int[output.size()];
        
        for(int i = 0; i<res.length; i++){
            sum+=output.get(i);
            res[i] = sum;
        }
        
      
       
        return get(root);
       
        
    
        
        
    }
}