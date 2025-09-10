// LeetCode: Buddy Strings (buddy-strings)
// Submission ID: 1765962294
// Language: java
// Timestamp (UTC): 2025-09-10T11:25:40Z

class Solution {
    public boolean buddyStrings(String s, String goal) {
        if(s.length()!=goal.length())return false;
        HashMap<Character,Integer>map = new HashMap<>();


        for(char ch : s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }

        for(char ch : goal.toCharArray()){
            if(!map.containsKey(ch))return false;

            map.put(ch,map.get(ch)-1);
            if(map.get(ch) == 0)map.remove(ch);
        }

            int count = 0;
        HashSet<Character>set = new HashSet<>();
    
            for(int i = 0; i<s.length(); i++){
            char ch1 = s.charAt(i);
            char ch2 = goal.charAt(i);
            set.add(ch1);

            if(ch1!=ch2)count++;

            if(count>2)return false;
        }

        if(count == 2)return true;
     

    if(set.size()<s.length())return true;
        return false;

        
       

        
    }
}