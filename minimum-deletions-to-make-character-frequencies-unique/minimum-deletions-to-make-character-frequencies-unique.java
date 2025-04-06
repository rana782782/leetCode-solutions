// LeetCode: Minimum Deletions to Make Character Frequencies Unique (minimum-deletions-to-make-character-frequencies-unique)
// Submission ID: 1598697889
// Language: java
// Timestamp (UTC): 2025-04-06T16:23:35Z

class Solution {
    public int minDeletions(String s) {
        HashMap<Character,Integer>map = new HashMap<>();

      for(int i = 0; i<s.length(); i++){
        char ch = s.charAt(i);

        map.put(ch,map.getOrDefault(ch,0)+1);
      }

        HashSet<Integer>set = new HashSet<>();

        int count = 0;

        for(int freq : map.values()){

            if(set.contains(freq)){

                while(set.contains(freq) && freq>0){
                    freq--;
                    count++;
                }

                if(freq!=0)set.add(freq);
            }
            else{
                set.add(freq);
            }
        }

        return count;
    }
}