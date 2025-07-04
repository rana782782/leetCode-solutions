// LeetCode: Sort Characters By Frequency (sort-characters-by-frequency)
// Submission ID: 1686621365
// Language: java
// Timestamp (UTC): 2025-07-04T22:15:34Z

class Solution {
    public class Pair implements Comparable<Pair>{
        
        
        char ch;
         int freq;
        
        Pair(char ch, int freq){
            this.ch = ch;
            this.freq = freq;
        }
        
        public int compareTo(Pair o){
           return o.freq-this.freq;
        }
    }
    public String frequencySort(String s) {
        HashMap<Character,Integer>map = new HashMap<>();
        
        for(int i = 0; i<s.length(); i++){
            char ch = s.charAt(i);
            
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        
        
        PriorityQueue<Pair>pq = new PriorityQueue<>();
        
        for(char ch : map.keySet()){
            pq.add(new Pair(ch,map.get(ch)));
        }
        
        StringBuilder output = new StringBuilder();
        
        while(!pq.isEmpty()){
            Pair rem = pq.poll();
             char ch = rem.ch;
            
            int steps = rem.freq;
            
            while(steps-->0){
                output.append(ch);
                
            }
        }
        
        return output.toString();
        
    }
}