// LeetCode: Jewels and Stones (jewels-and-stones)
// Submission ID: 1690050452
// Language: java
// Timestamp (UTC): 2025-07-07T20:33:34Z

class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        HashSet<Character>set = new HashSet<>();
        
        for(int i = 0; i<jewels.length(); i++){
            char ch = jewels.charAt(i);
            set.add(ch);
        }
        
        int output = 0;
        
        for(int i = 0; i<stones.length(); i++){
            char ch = stones.charAt(i);
            
            if(set.contains(ch))output++;
        }
        
        return output;
    }
}