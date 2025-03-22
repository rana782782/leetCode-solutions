// LeetCode: Redistribute Characters to Make All Strings Equal (redistribute-characters-to-make-all-strings-equal)
// Submission ID: 1582046783
// Language: java
// Timestamp (UTC): 2025-03-22T07:20:46Z

class Solution {
    public boolean makeEqual(String[] words) {
        HashMap<Character,Integer> map = new HashMap<>();

        int totalLength = words.length;

        for(String str : words){
            
            for(int i = 0; i<str.length(); i++){
                char ch = str.charAt(i);

                map.put(ch,map.getOrDefault(ch,0)+1);
            }


        }


        for(int freq : map.values()){
            if(freq%totalLength!=0) return false;
        }

        return true;
    }
}