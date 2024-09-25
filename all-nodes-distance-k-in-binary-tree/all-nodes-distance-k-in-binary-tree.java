// LeetCode: All Nodes Distance K in Binary Tree (all-nodes-distance-k-in-binary-tree)
// Submission ID: 1401885975
// Language: java
// Timestamp (UTC): 2024-09-25T13:58:14Z

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public static void getRel(TreeNode root, HashMap<TreeNode, TreeNode>map) {
		 if(root == null) {
			 return;
		 }
		 
		 if(root.left!= null) {
			 map.put(root.left, root);
		 }
		 
		 if(root.right!= null) {
			 map.put(root.right, root);
		 }
		 
		 getRel(root.left,map);
		 getRel(root.right,map);
	 }
	
	 
	 public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
		 HashMap<TreeNode, TreeNode> map = new HashMap<>();
			getRel(root,map);
			List<Integer> ans = new ArrayList<>();
			
			HashSet<TreeNode> visited = new HashSet<>();
			
			Queue<TreeNode> q = new LinkedList<>();
			q.add(target);
			while(!q.isEmpty()) {
				int size = q.size();
				while(size--!=0) {
					TreeNode rem = q.poll();
					visited.add(rem);
					if(k == 0) {
						ans.add(rem.val);
					}
					
					if(map.containsKey(rem) && !visited.contains(map.get(rem))) {
						q.add(map.get(rem));
					}
					
					if(rem.left!=null && !visited.contains(rem.left)) {
						q.add(rem.left);
					}
					
					if(rem.right!=null && !visited.contains(rem.right)) {
						q.add(rem.right);
					}
				}
				k--;
				if(k<0) {
					break;
				}
			}
			
			return ans;
	    }
}