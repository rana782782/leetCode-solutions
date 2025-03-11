// LeetCode: Maximum Number of Events That Can Be Attended II (maximum-number-of-events-that-can-be-attended-ii)
// Submission ID: 1570560987
// Language: java
// Timestamp (UTC): 2025-03-11T18:06:34Z

class Solution {
    static int memo[][];
    public static int solution(int events[][], int idx, int k){
        if(k<0) return 0;

        if(k == 0 || idx>=events.length) return 0;

        if(memo[idx][k]!=-1) return memo[idx][k];

        int nextIdx = idx+1;

        while(nextIdx<events.length && events[nextIdx][0]<=events[idx][1]) nextIdx++;

        int taken = events[idx][2]+solution(events,nextIdx,k-1);
        int notTaken = solution(events,idx+1,k);

        return memo[idx][k] = Math.max(taken,notTaken);
    }
    public int maxValue(int[][] events, int k) {
        Arrays.sort(events,(a,b)->Integer.compare(a[0],b[0]));
        memo = new int[events.length][k+1];
        for(int i = 0; i<memo.length; i++){
            Arrays.fill(memo[i],-1);
        }

        return solution(events,0,k);
    }
}