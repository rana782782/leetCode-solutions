// LeetCode: Find and Replace Pattern (find-and-replace-pattern)
// Submission ID: 1767037032
// Language: java
// Timestamp (UTC): 2025-09-11T10:14:49Z

class Solution {
    public static String getCode(String pattern){
        HashMap<Character,Integer>map = new HashMap<>();

        StringBuilder str = new  StringBuilder();

        for(int i = 0; i<pattern.length(); i++){
            char ch = pattern.charAt(i);

            if(map.containsKey(ch)){
                str.append(map.get(ch));
            }
            else{
                str.append(i);
                map.put(ch,i);
            }
        }

        return str.toString();
    } 
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        

        List<String>output = new ArrayList<>();

        String orgCode = getCode(pattern);

        for(String str : words){
            String currCode = getCode(str);

            if(currCode.equals(orgCode))output.add(str);
        }

        return output;
    }
}