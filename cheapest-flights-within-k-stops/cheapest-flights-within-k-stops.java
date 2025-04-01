// LeetCode: Cheapest Flights Within K Stops (cheapest-flights-within-k-stops)
// Submission ID: 1593041372
// Language: java
// Timestamp (UTC): 2025-04-01T11:32:41Z

class Solution {

    public static class Pair{
        int src;
         int price;

         Pair(int src,  int price){
            this.src = src;
            this.price = price;
         }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
        ArrayList<ArrayList<Pair>> graph = new ArrayList<>();

        for(int i = 0; i<n; i++){
            graph.add(new ArrayList<>());
        }


        for(int i = 0; i<flights.length; i++){
            int u = flights[i][0];
            int v = flights[i][1];
            int cost = flights[i][2];

            graph.get(u).add(new Pair(v,cost));
        }

        int cost[] = new int[n];
        Arrays.fill(cost,Integer.MAX_VALUE);
        cost[src] = 0;

        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(src,0));

        int level = 0;

        while(q.size()!=0 && level<=k){
            int size = q.size();

            while(size-->0){
                Pair rem = q.poll();

                for( Pair p : graph.get(rem.src)){

                    if(rem.price+p.price<cost[p.src]){

                        cost[p.src] = rem.price+p.price;
                        q.add(new Pair(p.src,rem.price+p.price));
                    }
                }
            }

            level++;
        }


        return cost[dst] == Integer.MAX_VALUE ? -1 : cost[dst];
    }

    
}