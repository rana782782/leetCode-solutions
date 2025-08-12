// LeetCode: Remove Duplicate Letters (remove-duplicate-letters)
// Submission ID: 1732311609
// Language: java
// Timestamp (UTC): 2025-08-12T10:27:27Z

import java.util.*;

class Solution {
    public String removeDuplicateLetters(String s) {
        // Step 1: Count frequency of each character
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        Stack<Character> st = new Stack<>();
        HashSet<Character> set = new HashSet<>();

        // Step 2: Iterate through characters
        for (char ch : s.toCharArray()) {
            // Decrease frequency count (we are using this char now)
            map.put(ch, map.get(ch) - 1);

            // If already in stack, skip it
            if (set.contains(ch)) continue;

            // While stack has bigger char than current and that bigger char appears later again
            while (!st.isEmpty() && st.peek() > ch && map.get(st.peek()) > 0) {
                set.remove(st.pop());
            }

            st.push(ch);
            set.add(ch);
        }

        // Step 3: Build output string
        StringBuilder output = new StringBuilder();
        for (char c : st) {
            output.append(c);
        }
        return output.toString();
    }
}
