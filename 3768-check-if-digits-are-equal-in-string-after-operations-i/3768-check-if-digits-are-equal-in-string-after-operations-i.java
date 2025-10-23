class Solution {
    public static String twoDigit(String str){
        StringBuilder output = new StringBuilder(str);

        while(output.length()>2){
            StringBuilder currStr = new StringBuilder();
            for(int i = 0; i<output.length()-1; i++){
                int num = (output.charAt(i)-'0')+(output.charAt(i+1)-'0');
                int rem = num%10;
                currStr.append(rem);
            }
            output = new StringBuilder(currStr);
        }

        return output.toString();

    }
    public boolean hasSameDigits(String s) {
        if(s.length() ==1)return false;

        String modified = twoDigit(s);
        if(modified.length() <=1)return false;

        return modified.charAt(0) == modified.charAt(1) ? true : false;
    }
}