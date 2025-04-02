// LeetCode: Shortest Distance After Road Addition Queries I (shortest-distance-after-road-addition-queries-i)
// Submission ID: 1594589433
// Language: java
// Timestamp (UTC): 2025-04-02T16:06:29Z

class Solution {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for(int i = 0; i<n; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i<n-1; i++){
            graph.get(i).add(i+1);
        }

        int output[] = new int[queries.length];
        

        int idx = 0;
        for(int d[] : queries){
            graph.get(d[0]).add(d[1]);
            int cost[] = new int[n];
        Arrays.fill(cost,Integer.MAX_VALUE);
        cost[0] = 0;

            Queue<Integer>q = new LinkedList<>();
            q.add(0);

            while(q.size()!=0){
                int size = q.size();

                while(size-->0){
                    int src = q.poll();

                    for(int dest : graph.get(src)){

                                if(cost[src]+1<cost[dest]){
                                    cost[dest] = cost[src]+1;
                                    q.add(dest);
                                }
                    }
                }
            }

            output[idx++] = cost[n-1];
        }

        return output;
    }
}