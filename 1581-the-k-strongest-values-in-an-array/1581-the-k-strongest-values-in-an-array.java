class Solution {
    public static class Pair implements Comparable<Pair>{
        int ele,diff;
        Pair(int ele, int diff){
            this.ele = ele;
            this.diff = diff;
        }

        public int compareTo(Pair o){
            if(this.diff == o.diff)return o.ele-this.ele;
                return o.diff-this.diff;
        }
    }
    public int[] getStrongest(int[] arr, int k) {
        Arrays.sort(arr);

        PriorityQueue<Pair>pq = new PriorityQueue<>();
        int n = arr.length;
        int m = (n-1)/2;
        for(int ele : arr){
            int diff = Math.abs(ele-arr[m]);
            pq.add(new Pair(ele,diff));
        }

        int output[] = new int[k];
        int idx = 0;
        while(k-->0){
            Pair rem = pq.poll();
            output[idx++] = rem.ele;
        }

        return output;
    }
}