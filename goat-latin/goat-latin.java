// LeetCode: Goat Latin (goat-latin)
// Submission ID: 1760363344
// Language: java
// Timestamp (UTC): 2025-09-05T10:52:21Z

class Solution {
    public static String fxn(String str){
        StringBuilder temp = new StringBuilder();
        char ch = str.charAt(0);
        char lower = Character.toLowerCase(ch);
        if(lower == 'a' || lower =='e' || lower == 'i' || lower == 'o' || lower == 'u'){
            temp.append(str);
            temp.append("ma");
        }
        else{
            temp.append(str.substring(1,str.length()));
            temp.append(ch);
            temp.append("ma");
        }

        return temp.toString();
    }
    public String toGoatLatin(String sentence) {
        String arr[] = sentence.split(" ");

        StringBuilder output = new StringBuilder();
        StringBuilder lastChar = new StringBuilder();
        lastChar.append('a');

        for(String str : arr){
            String currStr = fxn(str);
            currStr+=lastChar.toString();
            if(output.length()>0)output.append(" ");
            output.append(currStr);
            lastChar.append('a');
        }

        System.out.print(output.toString());
        return output.toString();
    }
}