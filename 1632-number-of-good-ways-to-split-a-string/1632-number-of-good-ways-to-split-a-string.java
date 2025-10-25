class Solution {
    public int numSplits(String s) {
        if(s.length() == 1)return 0;
        HashMap<Character,Integer>map1 = new HashMap<>();
        HashMap<Character,Integer>map2 = new HashMap<>();

        map1.put(s.charAt(0),1);
        for(int i = 1; i<s.length(); i++){
            char ch = s.charAt(i);
            map2.put(ch,map2.getOrDefault(ch,0)+1);
        }

        int output = 0;
        for(int i = 1; i<s.length(); i++){
            if(map1.size() == map2.size())output+=1;
            char ch = s.charAt(i);
            map1.put(ch,map1.getOrDefault(ch,0)+1);
            map2.put(ch,map2.get(ch)-1);
            if(map2.get(ch) == 0)map2.remove(ch);

        }

        return output;
    }
}