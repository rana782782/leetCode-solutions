class Solution {

    public static class Pair implements Comparable<Pair>{
        int num,freq;

        Pair(int num, int freq){
            this.num = num;
            this.freq = freq;
        }

        public int compareTo(Pair o){
           return o.freq-this.freq;
        }


    }
    public int minSetSize(int[] arr) {
        HashMap<Integer,Integer>map = new HashMap<>();
        for(int ele : arr){
            map.put(ele,map.getOrDefault(ele,0)+1);
        }

        PriorityQueue<Pair>pq = new PriorityQueue<>();
        for(int key : map.keySet()){
            pq.add(new Pair(key,map.get(key)));
        }

        int sum = arr.length/2;
        int curr_sum = 0;

        int count = 0;
        while(curr_sum<sum){
            Pair rem = pq.poll();
            curr_sum+=rem.freq;
            count++;
        }
        return count;
    }
}