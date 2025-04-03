// LeetCode: Find Players With Zero or One Losses (find-players-with-zero-or-one-losses)
// Submission ID: 1595455758
// Language: java
// Timestamp (UTC): 2025-04-03T10:36:16Z

class Solution {
   	 public List<List<Integer>> findWinners(int[][] matches) {
	        
	        HashSet<Integer>set = new HashSet<>();
	        
	        HashMap<Integer,Integer>map = new HashMap<>();
	        
	        for(int m[] : matches) {
	        	int win = m[0];
	        	
	        	int lose = m[1];
	        	
	        	set.add(win);
	        	
	        	map.put(lose,map.getOrDefault(lose, 0)+1);
	        	
	        }
	        
	        List<Integer>winner = new ArrayList<>();
	        List<Integer>looser = new ArrayList<>();
	        
	        for(int ele : set) {
	        	if(map.containsKey(ele))continue;
	        	
	        	winner.add(ele);
	        }
	        
	        
	        for(int ele  : map.keySet()) {
	        	
	        	if(map.get(ele) == 1)looser.add(ele);
	        }
	        
	        List<List<Integer>>output = new ArrayList<>();
	        
	        Collections.sort(winner);
	        Collections.sort(looser);
	        
	        output.add(winner);
	        output.add(looser);
	        
	        return output;
	    }
}