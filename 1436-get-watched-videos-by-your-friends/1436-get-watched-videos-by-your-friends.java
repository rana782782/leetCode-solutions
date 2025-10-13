class Solution {
    public class Pair implements Comparable<Pair>{
        String ch;
        int freq;

        Pair(String ch,int freq){
            this.ch = ch;
            this.freq = freq;
        }

        public int compareTo(Pair o){
            if(this.freq!=o.freq)return this.freq-o.freq;
             return this.ch.compareTo(o.ch);
        }
    }
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        List<Integer>output = new ArrayList<>();
    int n = friends.length;
        Queue<Integer>q = new LinkedList<>();
        int l = 0;
        q.add(id);
        boolean visited[] = new boolean[n];

        while(!q.isEmpty()){
           int size = q.size();
           while(size-->0){
                    int rem = q.poll();
           if(visited[rem])continue;

           visited[rem] = true;

           if(l == level){
            output.add(rem);
            System.out.println(rem);
            continue;
           }
           for(int nbrs : friends[rem])q.add(nbrs);
           }
           l++;
        }
        
        HashMap<String,Integer>map = new HashMap<>();
        for(int ele : output){
            for(String str : watchedVideos.get(ele)){
                map.put(str,map.getOrDefault(str,0)+1);
            }
        }

        PriorityQueue<Pair>pq = new PriorityQueue<>();
        for(String key : map.keySet()){
            Pair p = new Pair(key,map.get(key));
            pq.add(p);
        }

        List<String>ans = new ArrayList<>();
        while(!pq.isEmpty()){
            Pair rem = pq.poll();
            ans.add(rem.ch);
        }

        return ans;
    

    }

   
}