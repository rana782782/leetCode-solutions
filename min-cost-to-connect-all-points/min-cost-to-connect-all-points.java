// LeetCode: Min Cost to Connect All Points (min-cost-to-connect-all-points)
// Submission ID: 1474352468
// Language: java
// Timestamp (UTC): 2024-12-09T13:28:15Z

class Solution {
   class  Pair implements Comparable<Pair>{
		int src; 
		
		int wt;
		Pair(int src,  int wt){
			this.src = src;
			
			this.wt = wt;
		}
		
		public int compareTo(Pair o) {
			return this.wt-o.wt;
		}

		
	}
	
	class Edge{
		int src; 
		int nbr;
		int wt;
		
		Edge(int src, int nbr, int wt){
			this.src = src;
			this.nbr = nbr;
			this.wt = wt;
		}
	}
	
public int minCostConnectPoints(int[][] points) {
       
      
        ArrayList<Edge> graph[] = new ArrayList[points.length];
        
        for(int i = 0; i<graph.length; i++) {
        	graph[i] = new ArrayList<>();
        }
        for(int i = 0; i<points.length-1; i++) {
        	int pt1[] = points[i];
        	
        	for(int j = i+1; j<points.length; j++) {
        		int pt2[] = points[j];
        		
        		int distance = Math.abs(pt1[0]-pt2[0])+Math.abs(pt1[1]-pt2[1]);
        		
        		graph[i].add(new Edge(i,j,distance));
        		graph[j].add(new Edge(j,i,distance));
        		        		
        	}
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        boolean visited[] = new boolean[points.length];
        
        pq.add(new Pair(0,0));
        
        int cost = 0;
        
        while(pq.size()!=0) {
        	Pair rem= pq.poll();
        	if(visited[rem.src]) {
        		continue;
        	}
        	
        	visited[rem.src] = true;
         cost+= rem.wt;
         
         for(Edge e: graph[rem.src]) {
        	 if(!visited[e.nbr]) {
        		 pq.add(new Pair(e.nbr,e.wt));
        	 }
         }
        }
        
        return cost;

    }
}