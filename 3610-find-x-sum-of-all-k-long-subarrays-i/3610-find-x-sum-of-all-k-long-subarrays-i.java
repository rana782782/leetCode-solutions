class Solution {
    public static class Pair implements Comparable<Pair>{
        int num,freq;

        Pair(int num,int freq){
            this.num = num;
            this.freq = freq;
        }

        public int compareTo(Pair o){
            if(this.freq!=o.freq)return this.freq-o.freq;
            return this.num-o.num;
        }
    }

    public static int calc(HashMap<Integer,Integer>map,int x){
        PriorityQueue<Pair>pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int key : map.keySet()){
            pq.add(new Pair(key,map.get(key)));
        }

        int output = 0;
        while(x-->0 && !pq.isEmpty()){
            Pair rem = pq.poll();
            output+=(rem.num*rem.freq);
        }
        return output;
    }
    public int[] findXSum(int[] nums, int k, int x) {
            int n = nums.length;
            int output[] = new int[n-k+1];
            int idx = 0;
            HashMap<Integer,Integer>map = new HashMap<>();

            while(idx<k){
                int ele = nums[idx];
                map.put(ele,map.getOrDefault(ele,0)+1);
                idx++;
            }

        int left = 0;
        int fill = 0;
        while(idx<n){
            int ans = calc(map,x);
            output[fill++] = ans;
            int ele = nums[idx];
            map.put(ele,map.getOrDefault(ele,0)+1);
            ele = nums[left];
            map.put(ele,map.get(ele)-1);
            if(map.get(ele) == 0)map.remove(ele);
            idx++;
            left++;
        }


        output[fill] = calc(map,x);
        return output;
    }
}