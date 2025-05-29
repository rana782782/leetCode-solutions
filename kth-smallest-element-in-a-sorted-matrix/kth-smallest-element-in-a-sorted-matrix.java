// LeetCode: Kth Smallest Element in a Sorted Matrix (kth-smallest-element-in-a-sorted-matrix)
// Submission ID: 1647526938
// Language: java
// Timestamp (UTC): 2025-05-29T02:23:57Z

class Solution {

    public static void insert(int currNum,PriorityQueue<Integer>pq, int k){

        if(pq.size()<k)pq.add(currNum);
        else if(pq.peek()>currNum){
            pq.poll();
            pq.add(currNum);
        }

    }
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer>pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0; i<matrix.length; i++){
            for(int j = 0; j<matrix[0].length; j++){
                insert(matrix[i][j],pq,k);
            }
        }

        return pq.poll();
    }
}