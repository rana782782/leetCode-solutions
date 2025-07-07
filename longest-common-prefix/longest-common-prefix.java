// LeetCode: Longest Common Prefix (longest-common-prefix)
// Submission ID: 1689657678
// Language: java
// Timestamp (UTC): 2025-07-07T14:36:04Z

class Solution {
    
    public static boolean isPossible(char ch, String strs[],int pos){
        
        for(int i = 1; i<strs.length; i++){
            String word = strs[i];
            
            if(pos<word.length()){
                if(word.charAt(pos)!=ch)return false;
            }
            else{
                return false;
            }
                
            
        }
        
        return true;
    }
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 1)return strs[0];
        
        int i = 0;
        String firstWord = strs[0];
        
        while(i<firstWord.length()){
            char ch = firstWord.charAt(i);
            
            if(!isPossible(ch,strs,i)){
                return firstWord.substring(0,i);
            }
            
            i++;
        }
        
        return firstWord;
    }
}