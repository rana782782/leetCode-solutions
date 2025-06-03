// LeetCode: Sort Array by Increasing Frequency (sort-array-by-increasing-frequency)
// Submission ID: 1652939645
// Language: java
// Timestamp (UTC): 2025-06-03T17:19:51Z

class Solution {
    public static class Pair implements Comparable<Pair>{
        int ele,freq;
        
        Pair(int ele, int freq){
            this.ele = ele;
            this.freq = freq;
        }
        
        public int compareTo(Pair o){
            if(this.freq == o.freq)return o.ele-this.ele;
           return this.freq-o.freq;
        }
    }
    public int[] frequencySort(int[] nums) {
        HashMap<Integer,Integer>map = new HashMap<>();
        
        for(int i = 0; i<nums.length; i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        
        List<Pair>output = new ArrayList<>();
        
        for(int key : map.keySet()){
            Pair p = new Pair(key,map.get(key));
            output.add(p);
        }
        
        Collections.sort(output);
        
        int res[] = new int[nums.length];
        int idx = 0;
        for(Pair p : output){
            int steps = p.freq;
            
            while(steps!=0){
                res[idx++] = p.ele;
                steps--;
            }
        }
        
        return res;
    }
}