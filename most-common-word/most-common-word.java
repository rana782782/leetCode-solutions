// LeetCode: Most Common Word (most-common-word)
// Submission ID: 1757919843
// Language: java
// Timestamp (UTC): 2025-09-03T06:55:46Z

class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        HashMap<String,Integer>map = new HashMap<>();
        HashSet<String>set = new HashSet<>();
        for(String str : banned){
            set.add(str);
        }

        int i = 0;
            StringBuilder currStr = new StringBuilder();
        while(i<paragraph.length()){
            char ch = paragraph.charAt(i);

            if((ch>='a'&&ch<='z') || (ch>='A'&&ch<='Z')){
                currStr.append(Character.toLowerCase(ch));
            }
            else{
                if(currStr.length()>0 && (set.size() == 0 || !set.contains(currStr.toString()))){
                  System.out.println(currStr.toString());
                    map.put(currStr.toString(),map.getOrDefault(currStr.toString(),0)+1);
                }
                currStr = new StringBuilder();
            }
            i++;
        }
    if(currStr.length()>0){
        map.put(currStr.toString(),map.getOrDefault(currStr.toString(),0)+1);
    }

        int freq = 0;
        String output = "";

        for(String key : map.keySet()){
            System.out.println(key+"_"+map.get(key));
            if(map.get(key)>freq){
                freq = map.get(key);
                output = key;
            }
        }

        return output;
    }
}