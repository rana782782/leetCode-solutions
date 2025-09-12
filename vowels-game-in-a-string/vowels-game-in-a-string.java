// LeetCode: Vowels Game in a String (vowels-game-in-a-string)
// Submission ID: 1768125616
// Language: java
// Timestamp (UTC): 2025-09-12T09:56:07Z

class Solution {
    public boolean doesAliceWin(String s) {
        for(char ch:s.toCharArray()){
            if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u' )
                return true;
        }
        return false;
    }
}