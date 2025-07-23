// LeetCode: Minimum Window Substring (minimum-window-substring)
// Submission ID: 1708632747
// Language: java
// Timestamp (UTC): 2025-07-23T15:06:40Z

class Solution {
    public String minWindow(String s, String t) {
        int req = t.length();
        int curr_len = 0;

        HashMap<Character,Integer>map = new HashMap<>();
        for(int i = 0; i<t.length(); i++){
            char ch = t.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        int output = Integer.MAX_VALUE;
        String ans = "";

        int l = 0; 
        int r = 0;

        while(r<s.length()){
            char ch = s.charAt(r);

            if(map.getOrDefault(ch,0)>=1)curr_len++;
            map.put(ch,map.getOrDefault(ch,0)-1);

            while(l<=r && curr_len == req){
                ch = s.charAt(l);
                int temp = r-l+1;
                if(temp<output){
                        output = temp;
                        ans = s.substring(l,r+1);
                }
                map.put(ch,map.get(ch)+1);
                if(map.get(ch)>=1)curr_len--;
                l++;
            }
        r++;
        }

        return ans;
    }
}