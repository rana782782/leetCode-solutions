class Solution {
    public static boolean isPrefix(String str,String word){
        int i = 0;
        while(i<word.length() && i<str.length()){
            if(str.charAt(i) == word.charAt(i))i++;
            else{
                return false;
            }
        }

        return i == word.length() ? true : false;
    }
    public int isPrefixOfWord(String sentence, String searchWord) {
        String arr[] = sentence.split(" ");
       for(int i = 0; i<arr.length; i++){
             if(isPrefix(arr[i],searchWord))return i+1;
       }

       return -1;
    }
}