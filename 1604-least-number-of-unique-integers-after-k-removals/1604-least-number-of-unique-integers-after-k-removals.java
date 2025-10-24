class Solution {
    public static class Pair implements Comparable<Pair>{
        int num,freq;

        Pair(int num,int freq){
            this.num = num;
            this.freq = freq;
        }

        public int compareTo(Pair o){
            return this.freq-o.freq;
        }
    }
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        HashMap<Integer,Integer>map = new HashMap<>();

        for(int ele : arr){
            map.put(ele,map.getOrDefault(ele,0)+1);
        }

        PriorityQueue<Pair>pq = new PriorityQueue<>();
        for(int key : map.keySet()){
            pq.add(new Pair(key,map.get(key)));
        }


        while(k>0){
            Pair rem = pq.poll();
            if(rem.freq>k){
               return pq.size()+1;
            }
            else if(rem.freq == k){
                return pq.size();
            }
            else{
                k-=rem.freq;
            }
        }

        return pq.size();
    }
}