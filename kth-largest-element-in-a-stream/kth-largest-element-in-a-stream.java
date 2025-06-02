// LeetCode: Kth Largest Element in a Stream (kth-largest-element-in-a-stream)
// Submission ID: 1652076114
// Language: java
// Timestamp (UTC): 2025-06-02T20:01:57Z

class KthLargest {
        static PriorityQueue<Integer>pq;
        static int K;
    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>();
        K = k;
        
        for(int i= 0; i<nums.length; i++){
            if(pq.size()<k)pq.add(nums[i]);
            else if(pq.peek()<nums[i]){
                pq.poll();
                pq.add(nums[i]);
            }
        }
    }
    
    public int add(int val) {
        if(pq.size()<K)pq.add(val);
        else if(pq.peek()<val){
            pq.poll();
            pq.add(val);
        }
        
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */