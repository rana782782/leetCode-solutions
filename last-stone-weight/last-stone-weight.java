// LeetCode: Last Stone Weight (last-stone-weight)
// Submission ID: 1595464609
// Language: java
// Timestamp (UTC): 2025-04-03T10:48:38Z

class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
	        for(int i : stones) {
	        	pq.add(i);
	        }
	        while(pq.size()>1) {
	        	int y = pq.poll();
	        	int  x = pq.poll();
	        	if(x!=y) {
	        		pq.add(y-x);
	        	}
	        }
	        
	        if(pq.isEmpty()) {
	        	return 0;
	        }
	        return pq.peek();
    }
}