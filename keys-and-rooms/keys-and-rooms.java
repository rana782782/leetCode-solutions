// LeetCode: Keys and Rooms (keys-and-rooms)
// Submission ID: 1764688086
// Language: java
// Timestamp (UTC): 2025-09-09T07:58:27Z

class Solution {
    public static  boolean canVisitAllRooms(List<List<Integer>> rooms) {
	        int n = rooms.size();
	        boolean visited[] = new boolean[n];
	        
	        Queue<Integer> q  = new LinkedList<>();
	        List<Integer> first = rooms.get(0);
	        
	        for(int i : first) {
	        	q.add(i);
	        }
	        visited[0] = true;
	        
	        
	        while(q.size()!=0) {
	        	int roomNo = q.poll();
	        	
	        	if(!visited[roomNo]) {
	        		
	        		visited[roomNo] = true;
	        		
	        		List<Integer>keys = rooms.get(roomNo);
	        		
	        		for(int i : keys) {
	        			if(!visited[i]) {
	        				q.add(i);
	        			}
	        		}
	        	}
	        }
	        
	        
	        for(int i = 0; i<n; i++) {
	        	if(visited[i] == false) return false;
	        }
	        
	        
	        return true;
	    }
}