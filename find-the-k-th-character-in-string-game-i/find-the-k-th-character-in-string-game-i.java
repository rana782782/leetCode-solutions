// LeetCode: Find the K-th Character in String Game I (find-the-k-th-character-in-string-game-i)
// Submission ID: 1685432435
// Language: java
// Timestamp (UTC): 2025-07-03T19:10:55Z

class Solution {
    public char kthCharacter(int k) {
        StringBuilder prev = new StringBuilder("a");
        StringBuilder curr = new StringBuilder();

        while(prev.length()<k){
            curr.append(prev);

            for(int i = 0; i<prev.length(); i++){
                char ch = prev.charAt(i);
                    char next = (char)('a' + (ch - 'a' + 1) % 26);
                curr.append(next);
            }

            prev = curr;
            curr = new StringBuilder();
        }

        System.out.println(prev);
        return prev.charAt(k-1);


    }
}