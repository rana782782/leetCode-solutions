// LeetCode: Reveal Cards In Increasing Order (reveal-cards-in-increasing-order)
// Submission ID: 1772579926
// Language: java
// Timestamp (UTC): 2025-09-16T09:52:17Z

import java.util.*;

class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);  // Step 1: Sort the deck
        int n = deck.length;
        int[] result = new int[n];

        Queue<Integer> queue = new LinkedList<>();
        // Step 2: Initialize the queue with indices
        for (int i = 0; i < n; i++) {
            queue.offer(i);
        }

        // Step 3: Place cards in the correct position
        for (int card : deck) {
            int index = queue.poll();
            result[index] = card;
            if (!queue.isEmpty()) {
                queue.offer(queue.poll());
            }
        }

        return result;
    }
}
