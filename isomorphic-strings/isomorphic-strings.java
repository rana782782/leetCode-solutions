// LeetCode: Isomorphic Strings (isomorphic-strings)
// Submission ID: 1590011417
// Language: java
// Timestamp (UTC): 2025-03-29T12:31:43Z

class Solution {
    public boolean isIsomorphic(String s, String t) {

        if(s.length() == 1) return true;

        HashMap<Character,Character> map1 = new HashMap<>();
        HashMap<Character,Character> map2 = new HashMap<>();

        int i = 0;

        while(i<s.length()){

            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);

            if(map1.containsKey(ch1) && map1.get(ch1)!=ch2) return false;
            if(map2.containsKey(ch2) && map2.get(ch2)!=ch1) return false;

            else{
                map1.put(ch1,ch2);
                map2.put(ch2,ch1);
            }
            i++;
        }

        return true;
    }
}