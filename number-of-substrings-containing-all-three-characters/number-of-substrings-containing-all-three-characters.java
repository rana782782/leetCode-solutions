// LeetCode: Number of Substrings Containing All Three Characters (number-of-substrings-containing-all-three-characters)
// Submission ID: 1569717706
// Language: java
// Timestamp (UTC): 2025-03-11T01:26:03Z

class Solution {
    public int numberOfSubstrings(String s) {
        int right = 0;
        int left = 0;
         int n = s.length();
          int ans = 0;
          HashMap<Character,Integer> map = new HashMap<>();

          while(right<n){
            char ch = s.charAt(right);
            map.put(ch,map.getOrDefault(ch,0)+1);
            while(map.getOrDefault('a',0)>0 && map.getOrDefault('b',0)>0 && map.getOrDefault('c',0)>0){
                ans+=n-right;
                char release = s.charAt(left);
                map.put(release,map.get(release)-1);
                left++;
               }
               right++;
          }
          return ans;
    }
}