class Solution {
    public static class Pair implements Comparable<Pair>{
        int num,freq;

        Pair(int num, int freq){
            this.num = num;
            this.freq = freq;
        }

        public int compareTo(Pair o){
            if(this.freq!=o.freq){
                return this.freq-o.freq;
            }
            return this.num-o.num;
        }
    }

    public static int power(int x){
         if(x == 1)return 0;
        if(x%2 == 0)return 1+power(x/2);
        else{
            return 1+power(3*x+1);
        }
    }
    public int getKth(int lo, int hi, int k) {
        PriorityQueue<Pair>pq= new PriorityQueue<>();
 
        for(int ele = lo; ele<=hi; ele++){
            int freq = power(ele);
            System.out.println(ele+"_"+freq);
            pq.add(new Pair(ele,freq));
        }
        
        while(k-->1){

           Pair p = pq.poll();
           
        }

        return pq.poll().num;
    }
}