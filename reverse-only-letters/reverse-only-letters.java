// LeetCode: Reverse Only Letters (reverse-only-letters)
// Submission ID: 1768185875
// Language: java
// Timestamp (UTC): 2025-09-12T11:15:36Z

class Solution {
    public static boolean isAlphabet(char ch) {
        return (ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z');
    }

    public String reverseOnlyLetters(String s) {
        char[] result = new char[s.length()];
        int j = s.length() - 1;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (isAlphabet(ch)) {
             
                while (j >= 0 && !isAlphabet(s.charAt(j))) {
                    j--;
                }
                result[i] = s.charAt(j);
                j--;
            } else {
                result[i] = ch;
            }
        }
        return new String(result);
    }
}
