// LeetCode: Longest Repeating Character Replacement (longest-repeating-character-replacement)
// Submission ID: 1725434704
// Language: java
// Timestamp (UTC): 2025-08-06T09:08:27Z

class Solution {
    public static int maxi(HashMap<Character,Integer>map){
        int max = 0;

        for(int val : map.values())max = Math.max(max,val);
        
        return max;
    }
    
    public int characterReplacement(String s, int k) {
        HashMap<Character,Integer>map = new HashMap<>();

        int output = 0;

        int i = 0;
         int j =0;

         while(i<s.length()){

            char ch = s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);

            

            while(j<=i && (i-j+1)-maxi(map)>k){
                ch = s.charAt(j);
                map.put(ch,map.get(ch)-1);
                if(map.get(ch) == 0)map.remove(ch);
                j++;
            }

            output = Math.max(output,i-j+1);
            i++;
         }

         return output;
    }
}