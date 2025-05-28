// LeetCode: Maximum Product After K Increments (maximum-product-after-k-increments)
// Submission ID: 1647444872
// Language: java
// Timestamp (UTC): 2025-05-28T22:47:19Z

class Solution {
    public int maximumProduct(int[] nums, int k) {
        PriorityQueue<Integer>pq = new PriorityQueue<>();
        int output = 1;
        int mod = 1000000007;

        for(int ele : nums){
            pq.add(ele);
        }

        while(k!=0){
            int currMin = pq.poll();
            pq.add(currMin+1);
            k--;
        }

while (!pq.isEmpty()) {
    int currNum = pq.poll();
    output = (int)(((long)currNum * output) % mod);  // cast to avoid overflow
}


        return output;
    }
}