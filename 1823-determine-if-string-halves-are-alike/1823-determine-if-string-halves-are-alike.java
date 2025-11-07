class Solution {

    public static int countVowel(String str){
        int output = 0;

        for(char ch : str.toCharArray()){
            if(isVowel(ch))output++;
        }

        return output;
    }

    public static boolean isVowel(Character ch){

        ch = Character.toLowerCase(ch);

        return ch == 'a'|| ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
    public boolean halvesAreAlike(String s) {
        int n = s.length();
        String firstHalf = s.substring(0,n/2);
        String secHalf = s.substring(n/2,n);

        return countVowel(firstHalf) == countVowel(secHalf);
    }
}