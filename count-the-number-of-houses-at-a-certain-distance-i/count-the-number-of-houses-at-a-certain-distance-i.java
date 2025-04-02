// LeetCode: Count the Number of Houses at a Certain Distance I (count-the-number-of-houses-at-a-certain-distance-i)
// Submission ID: 1594440694
// Language: java
// Timestamp (UTC): 2025-04-02T13:46:02Z

class Solution {
    public int[] countOfPairs(int n, int x, int y) {
        ArrayList<ArrayList<Integer>>graph = new ArrayList<>();

        for(int i = 0; i<=n; i++){
            graph.add(new ArrayList<>());
        }

       for (int i = 1; i < n; i++) {
            graph.get(i).add(i + 1);
            graph.get(i + 1).add(i);
        }

        if(x!=y){
            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        int res[] = new int[n];

        for(int i = 1; i<=n; i++){
            int k = 0;
            Queue<Integer>q = new LinkedList<>();
            boolean visited[] = new boolean[n+1];
            Arrays.fill(visited,false);
            q.add(i);

            while(q.size()!=0){
                int size = q.size();

                while(size-->0){
                    if(k>=1)res[k-1]++;

                    int rem = q.poll();

                    visited[rem] = true;
                    for(int num : graph.get(rem)){
                        if(visited[num])continue;

                            visited[num] = true;
                        q.add(num);
                    }
                }
                k++;
            }
        }

        return res;
    }
}