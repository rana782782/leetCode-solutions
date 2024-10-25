// LeetCode: Find the Difference (find-the-difference)
// Submission ID: 1433488076
// Language: java
// Timestamp (UTC): 2024-10-25T15:48:32Z

class Solution {
    public char findTheDifference(String s, String t) {
        int sum = 0;
        for(int i = 0; i<t.length(); i++){
            char ch = t.charAt(i);
            System.out.println(ch-'0');
            sum+=(ch-'0');
        }

        for(int i = 0; i<s.length(); i++){
            char ch = s.charAt(i);
            System.out.println(ch-'0');
            sum-=(ch-'0');
        }
  System.out.println(sum);
        char ch = (char)(sum+'0');
        System.out.println(ch);
        return ch;
    }
}