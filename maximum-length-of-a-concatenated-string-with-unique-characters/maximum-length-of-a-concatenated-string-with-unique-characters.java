// LeetCode: Maximum Length of a Concatenated String with Unique Characters (maximum-length-of-a-concatenated-string-with-unique-characters)
// Submission ID: 1691368210
// Language: java
// Timestamp (UTC): 2025-07-09T00:10:02Z

class Solution {
    static int maxLength;
    public static boolean isPossible(String str){
        HashSet<Character>set = new HashSet<>();
        for(int i = 0; i<str.length(); i++){
            char ch = str.charAt(i);
            if(set.contains(ch))return false;
            
            set.add(ch);
        }
        return true;
    }
    public static void solution(int idx, List<String>arr,String curr){
        if(idx == arr.size()){
            if(isPossible(curr))maxLength = Math.max(maxLength,curr.length());
            
            return;
        }
        
        solution(idx+1,arr,curr+arr.get(idx));
        solution(idx+1,arr,curr);
    }
    public int maxLength(List<String> arr) {
        maxLength = 0;
        
        solution(0,arr,"");
        
        return maxLength;
    }
}