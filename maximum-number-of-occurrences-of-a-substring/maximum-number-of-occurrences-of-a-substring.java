// LeetCode: Maximum Number of Occurrences of a Substring (maximum-number-of-occurrences-of-a-substring)
// Submission ID: 1689603806
// Language: java
// Timestamp (UTC): 2025-07-07T13:45:36Z

class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        
        HashMap<Character,Integer>map = new HashMap<>();
        HashMap<String,Integer>output = new HashMap<>();
        
        int i = 0;
        
         int j = 0;
        
        while(i<s.length()){
            char ch = s.charAt(i);
            
            map.put(ch,map.getOrDefault(ch,0)+1);
            
            while(j<=i && (map.size()>maxLetters || i-j+1>minSize)){
                ch = s.charAt(j);
                map.put(ch,map.get(ch)-1);
                
                if(map.get(ch) == 0)map.remove(ch);
                
                j++;
            }
            
            if(i-j+1==minSize){
                String sub = s.substring(j,i+1);
                System.out.println(sub);
                output.put(sub,output.getOrDefault(sub,0)+1);
            }
            
            i++;
        }
        
        int res = 0;
        
        for(int val : output.values()){
            res = Math.max(res,val);
        }
        
        return res;
    }
}