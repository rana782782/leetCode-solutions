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
    static HashMap<TreeNode,TreeNode>parent;
    static HashSet<TreeNode>leaf;
    public static void assign(TreeNode root){
        if(root == null)return;
        if(root.left == null && root.right == null)leaf.add(root);

        if(root.left!=null){
            parent.put(root.left,root);
            assign(root.left);
        }
        if(root.right!=null){
            parent.put(root.right,root);
            assign(root.right);
        }
    }
    static int D;
    public static int bfs(TreeNode root){
        if(root == null)return 0;
            int output = 0;

            Queue<TreeNode>q = new LinkedList<>();
            q.add(root);
            int level = 0;
            HashSet<TreeNode>visited = new HashSet<>();

            while(!q.isEmpty()){
                int size = q.size();
                while(size-->0){
                    TreeNode rem = q.poll();
                    visited.add(rem);
                    if (leaf.contains(rem) && rem != root) output++;
                    if(rem.left!=null && !visited.contains(rem.left))q.add(rem.left);
                    if(rem.right!=null && !visited.contains(rem.right))q.add(rem.right);
                    if(parent.containsKey(rem) && !visited.contains(parent.get(rem)))q.add(parent.get(rem));
                }
                level++;
                if(level>D)break;
            }

            return output;
    }
    public int countPairs(TreeNode root, int distance) {
        parent = new HashMap<>();
        leaf = new HashSet<>();
            assign(root);
            D = distance;

            int ans = 0;
            for(TreeNode l : leaf){
                ans+=bfs(l);
            }

            return ans/2;

    }
}