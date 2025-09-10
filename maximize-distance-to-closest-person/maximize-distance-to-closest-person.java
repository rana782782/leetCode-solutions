// LeetCode: Maximize Distance to Closest Person (maximize-distance-to-closest-person)
// Submission ID: 1765880309
// Language: java
// Timestamp (UTC): 2025-09-10T09:40:09Z

class Solution {
    public int maxDistToClosest(int[] seats) {
        int n = seats.length;

        int dist[] = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);

        Queue<Integer>q = new LinkedList<>();
        for(int i = 0; i<n; i++){
            if(seats[i] == 1)q.add(i);
        }
        int level = 0;
        while(!q.isEmpty()){
            int size = q.size();
            while(size-->0){
                int idx = q.poll();
                if(idx-1>=0 && dist[idx-1]>level+1){
                    dist[idx-1] = level+1;
                    q.add(idx-1);
                }
                if(idx+1<n && dist[idx+1]>level+1){
                     dist[idx+1] = level+1;
                    q.add(idx+1);
                }
            }
            level++;
        }

        int ans = Integer.MIN_VALUE;

        for(int i = 0; i<n; i++){
            if(seats[i] == 0){
                ans = Math.max(ans,dist[i]);
            }
        }
        System.out.print(ans);
        return ans;
        
    }
}