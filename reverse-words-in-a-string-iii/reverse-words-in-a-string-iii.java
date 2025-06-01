// LeetCode: Reverse Words in a String III (reverse-words-in-a-string-iii)
// Submission ID: 1651078590
// Language: java
// Timestamp (UTC): 2025-06-01T20:42:46Z

class Solution {
    public static String fxn(String str){
        StringBuilder temp = new StringBuilder(str);
        temp.reverse();
        
        return temp.toString();
    }
    public String reverseWords(String s) {
        
        String arr[] = s.split(" ");
        
        
        for(int i = 0; i<arr.length; i++){
            
            String str = arr[i];
            
            String rev = fxn(str);
            arr[i] = rev;
        }
        
        StringBuilder output = new StringBuilder();
        
        for(int i = 0; i<arr.length; i++){
            if(i!=arr.length-1){
                output.append(arr[i]);
                output.append(" ");
            }
            else{
                output.append(arr[i]);
            }
        }
        
        return output.toString();
    }
}