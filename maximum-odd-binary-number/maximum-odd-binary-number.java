// LeetCode: Maximum Odd Binary Number (maximum-odd-binary-number)
// Submission ID: 1587820001
// Language: java
// Timestamp (UTC): 2025-03-27T07:03:46Z

class Solution {
    public String maximumOddBinaryNumber(String s) {
        if(s.length() == 1) return s;
        StringBuilder str = new StringBuilder();

        int length = s.length();
        int ones = 0;
        for(int i = 0; i<length; i++){
            char ch = s.charAt(i);

            if(ch-'0' == 1) ones++;
        }

        for(int i = 1; i<ones; i++){
            str.append("1");
        }

        for(int i = 1; i<=length-ones; i++){
            str.append("0");
        }
        str.append("1");

        return str.toString();
    }
}