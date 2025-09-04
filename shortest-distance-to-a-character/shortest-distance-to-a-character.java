// LeetCode: Shortest Distance to a Character (shortest-distance-to-a-character)
// Submission ID: 1758895073
// Language: java
// Timestamp (UTC): 2025-09-04T03:51:52Z

class Solution {
    public static class Pair implements Comparable<Pair>{
        int idx,dist;

        Pair(int idx, int dist){
            this.idx = idx;
            this.dist = dist;
        }

        public int compareTo(Pair o){
           return this.dist-o.dist;
        }
    }
    public int[] shortestToChar(String s, char c) {
        int n = s.length();

        int output[] = new int[n];

        PriorityQueue<Pair>pq = new PriorityQueue<>();
        for(int i = 0;  i<n; i++){
            char ch = s.charAt(i);
            if(ch == c){
                output[i] = 0;
                pq.add(new Pair(i,0));
            }
            else{
                output[i] = Integer.MAX_VALUE;
            }
        }


        while(!pq.isEmpty()){
            Pair rem = pq.poll();
            int idx = rem.idx;
            if(idx+1<n && s.charAt(idx+1)!=c && rem.dist+1<output[idx+1]){
                output[idx+1] = rem.dist+1;
                pq.add(new Pair(idx+1,rem.dist+1));
            }
            if(idx-1>=0 && s.charAt(idx-1)!=c && rem.dist+1<output[idx-1]){
                output[idx-1] = rem.dist+1;
                pq.add(new Pair(idx-1,rem.dist+1));
            }
        }

        for(int i =  0; i<n; i++){
            System.out.print(output[i]+"_");
        }

        return output;
    }
}