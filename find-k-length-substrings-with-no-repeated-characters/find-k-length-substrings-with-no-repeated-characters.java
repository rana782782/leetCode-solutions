// LeetCode: Find K-Length Substrings With No Repeated Characters (find-k-length-substrings-with-no-repeated-characters)
// Submission ID: 1703823339
// Language: java
// Timestamp (UTC): 2025-07-19T16:57:21Z

class Solution {
    public int numKLenSubstrNoRepeats(String s, int k) {
        if(k>s.length())return 0;
        HashMap<Character,Integer>map = new HashMap<>();
        
        int i = 0;
         int j = 0;
        int output = 0;
        
        while(i<k-1){
            char ch = s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
            i++;
        }
        
        while(i<s.length()){
            char ch = s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
            if(map.size() == k)output++;
            i++;
            
            ch = s.charAt(j);
            map.put(ch,map.get(ch)-1);
            if(map.get(ch) == 0)map.remove(ch);
            j++;
        }
        
        return output;
        
        
    }
}