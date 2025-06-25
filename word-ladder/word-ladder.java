// LeetCode: Word Ladder (word-ladder)
// Submission ID: 1676360957
// Language: java
// Timestamp (UTC): 2025-06-25T17:52:38Z

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return 0;

        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        int level = 1;

        while (!q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {
                String rem = q.poll();
                if (rem.equals(endWord)) return level;

                char[] chars = rem.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    char original = chars[i];
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        chars[i] = ch;
                        String next = new String(chars);
                        if (wordSet.contains(next)) {
                            q.add(next);
                            wordSet.remove(next); // Mark as visited
                        }
                    }
                    chars[i] = original;
                }
            }
            level++;
        }

        return 0;
    }
}
