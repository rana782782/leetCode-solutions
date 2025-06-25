// LeetCode: Words Within Two Edits of Dictionary (words-within-two-edits-of-dictionary)
// Submission ID: 1676440806
// Language: java
// Timestamp (UTC): 2025-06-25T19:07:40Z

class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> output = new ArrayList<>();

        for (String query : queries) {
            for (String dict : dictionary) {
                if (isWithinTwoEdits(query, dict)) {
                    output.add(query);
                    break;
                }
            }
        }

        return output;
    }

    private boolean isWithinTwoEdits(String a, String b) {
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                diff++;
                if (diff > 2) return false;
            }
        }
        return true;
    }
}
