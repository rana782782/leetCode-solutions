// LeetCode: Find Common Characters (find-common-characters)
// Submission ID: 1673225180
// Language: java
// Timestamp (UTC): 2025-06-23T03:36:00Z

class Solution {
    public static boolean isValid(char ch, HashMap<String,HashMap<Character,Integer>>map){
        
        for(HashMap<Character,Integer>subMap : map.values()){
            if(subMap.containsKey(ch)){
                subMap.put(ch,subMap.get(ch)-1);
                
                if(subMap.get(ch) == 0)subMap.remove(ch);
            }
            else{
                return false;
            }
        }
         
        return true;
       
    }
    public List<String> commonChars(String[] words) {
        HashMap<String,HashMap<Character,Integer>>map = new HashMap<>();
        
        for(int i = 1; i<words.length; i++){
            String str = words[i];
            HashMap<Character,Integer>subMap = new HashMap<>();
            for(int j = 0; j<str.length(); j++){
                char ch = str.charAt(j);
                subMap.put(ch,subMap.getOrDefault(ch,0)+1);
              
            }
            
            map.put(str,subMap);
        }
        
        
        
        List<String>output = new ArrayList<>();
        
        String str = words[0];
        
        for(int i = 0; i<str.length(); i++){
            char ch = str.charAt(i);
            if(isValid(ch,map))output.add(ch+"");
        }
        
        return output;
    }
}