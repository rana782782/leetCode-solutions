// LeetCode: String to Integer (atoi) (string-to-integer-atoi)
// Submission ID: 1690111176
// Language: java
// Timestamp (UTC): 2025-07-07T22:32:16Z

class Solution {
    public int myAtoi(String s) {
        if(s.length() == 0)return 0;
        int i = 0;
        
        int n = s.length();
        
        while(i<n && (s.charAt(i) == ' '))i++;
        
        int sign = 1;
        
        if( i<n && (s.charAt(i) == '-' || s.charAt(i) == '+')){
            sign = s.charAt(i) == '-' ? -1 : 1;
            i++;
        }
        
        long num = 0;
        
        while(i<n && (Character.isDigit(s.charAt(i)))){
            num = num*10+(s.charAt(i)-'0');
            
            if(sign == 1 && num>Integer.MAX_VALUE)return Integer.MAX_VALUE;
            if(sign == -1 && num>Integer.MAX_VALUE)return Integer.MIN_VALUE;
            i++;
        }
        
        num*=sign;
        
        return (int)num;
    }
}