// LeetCode: Most Profit Assigning Work (most-profit-assigning-work)
// Submission ID: 1760377315
// Language: java
// Timestamp (UTC): 2025-09-05T11:09:02Z

class Solution {
    	public class Pair implements Comparable<Pair>{
		int diff;
		int profit;
		
		Pair(int diff, int profit){
			this.diff = diff;
			this.profit = profit;
		}
		
		public int compareTo(Pair o) {
			return this.profit-o.profit;
		}
	}
	
	 public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
	        ArrayList<Pair> schema = new ArrayList<>();
	        
	        for(int i =0; i<difficulty.length; i++) {
	        	schema.add(new Pair(difficulty[i], profit[i]));
	        }
	        
	       Collections.sort(schema,Collections.reverseOrder());
	       
	       int output = 0;
           Arrays.sort(worker);
	       
	       for(int diff : worker) {
	    	   
	    	   for(Pair p : schema) {
	    		   if(diff>=p.diff) {
	    			   output+=p.profit;
	    			   break;
	    		   }
	    	   }
	       }
	       
	       return output;
	    }
}