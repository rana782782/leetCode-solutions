// LeetCode: Time Needed to Buy Tickets (time-needed-to-buy-tickets)
// Submission ID: 1590369551
// Language: java
// Timestamp (UTC): 2025-03-29T18:45:05Z

class Solution {
   	public static class Pair{
		int num;
		int idx;
		
		Pair(int num, int idx){
			this.num = num;
			this.idx = idx;
		}
	}
	 public int timeRequiredToBuy(int[] tickets, int k) {
	        
		 Queue<Pair> q = new LinkedList<>();
		 
		 for(int i = 0; i<tickets.length; i++) {
			 q.add(new Pair(tickets[i],i));
		 }
		 int time = 0;
		 
		 while(q.size()!=0) {
			 Pair rem = q.poll();
			 
			 time++;
			rem.num--;
			
			if(rem.num == 0 && rem.idx == k)return time;
			
			else if(rem.num>0)q.add(rem);
			
		 }
		 
		 return 0;
	    }
}