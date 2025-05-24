// LeetCode: Find Words Containing Character (find-words-containing-character)
// Submission ID: 1642880860
// Language: java
// Timestamp (UTC): 2025-05-24T09:55:05Z

class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer>output = new ArrayList<>();
        String chStr = x+"";

        for(int i = 0; i<words.length; i++){
            String str = words[i];
            if(str.contains(chStr)){
                output.add(i);
            }
        }

        return output;
    }
}