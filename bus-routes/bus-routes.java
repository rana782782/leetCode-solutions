// LeetCode: Bus Routes (bus-routes)
// Submission ID: 1472501335
// Language: java
// Timestamp (UTC): 2024-12-07T10:17:21Z

class Solution {
	   public int numBusesToDestination(int[][] routes, int source, int target) {
		   
		   if(source == target) {
			   return 0;
		   }
	        HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
	        
	        for(int i = 0; i<routes.length; i++) {
	        	int stops[] = routes[i];
	        	
	        	for(int j = 0; j<stops.length; j++) {
	        		if(map.containsKey(stops[j])) {
	        			map.get(stops[j]).add(i);
	        		}
	        		
	        		else {
	        			ArrayList<Integer> num = new ArrayList<>();
	        			num.add(i);
	        			map.put(stops[j], num);
	        		}
	        	}
	        }
	        
	        HashSet<Integer> busNum = new HashSet<>();
	        HashSet<Integer> busStops = new HashSet<>();
	        
	        Queue<Integer> q = new LinkedList<>();
	        
	        q.add(source);
	        busStops.add(source);
	        
	        int level = 0;
	        while(q.size()!=0) {
	        	int size =q.size();
	        	
	        	while(size-->0) {
	        		int stops = q.poll();
	        		
	        		if(stops == target) {
	        			return level;
	        		}
	        		else {
	        		if(map.containsKey(stops)) {
	ArrayList<Integer> buses = map.get(stops);
	        			
	        			for(int i = 0; i<buses.size(); i++) {
	        				int busNo = map.get(stops).get(i);
	        				if(!busNum.contains(busNo)) {
	        					int getStops[] = routes[busNo];
	        					
	        					for(int j = 0;j<getStops.length; j++) {
	        						if(!busStops.contains(getStops[j])){
	        							q.add(getStops[j]);
	        							busStops.add(getStops[j]);
	        						}
	        					}
	        					busNum.add(busNo);
	        				}
	        			}
	        		}
	        		}
	        	}
	        	level++;
	        }
	        return -1;
	        
	    }

}