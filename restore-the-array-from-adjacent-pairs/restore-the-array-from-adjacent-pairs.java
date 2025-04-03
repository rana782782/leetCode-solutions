// LeetCode: Restore the Array From Adjacent Pairs (restore-the-array-from-adjacent-pairs)
// Submission ID: 1595511686
// Language: java
// Timestamp (UTC): 2025-04-03T11:56:57Z

class Solution {
 static int output[];
	static int idx;
	
	public static void dfs(HashMap<Integer,List<Integer>>map,int vertex, HashSet<Integer>visited) {
		visited.add(vertex);
		output[idx++] = vertex;
		
		for(int nbrs : map.get(vertex)) {
			if(visited.contains(nbrs))continue;
			
			dfs(map, nbrs, visited);
		}
	}
	
	   public int[] restoreArray(int[][] adjacentPairs) {
	        HashMap<Integer,Integer> freq = new HashMap<>();

	        HashMap<Integer,List<Integer>>map = new HashMap<>();

	        for(int p[] : adjacentPairs){
	            freq.put(p[0],freq.getOrDefault(p[0], 0)+1);
	            
	            freq.put(p[1],freq.getOrDefault(p[1], 0)+1);
	            
	            if(map.containsKey(p[0])) {
	            	map.get(p[0]).add(p[1]);
	            }
	            else {
	            	List<Integer>l = new ArrayList<>();
	            	l.add(p[1]);
	            	map.put(p[0], l);
	            }
	            
	            
	            if(map.containsKey(p[1])) {
	            	map.get(p[1]).add(p[0]);
	            }
	            else {
	            	List<Integer>l = new ArrayList<>();
	            	l.add(p[0]);
	            	map.put(p[1], l);
	            }
	        }
	        
	        
	        HashSet<Integer>visited = new HashSet<>();
	        
	        int n = adjacentPairs.length+1;
	        
	         output = new int[n];
	         idx = 0;
	         
	         for(int ele : freq.keySet()) {
	        	 if(freq.get(ele) == 1) {
	        		 dfs(map, ele, visited);
	        		 break;
	        	 }
	         }
	         
	         return output;
	        
	        
	    }
}