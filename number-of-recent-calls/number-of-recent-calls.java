// LeetCode: Number of Recent Calls (number-of-recent-calls)
// Submission ID: 1771646856
// Language: java
// Timestamp (UTC): 2025-09-15T14:10:12Z

import java.util.*;

class RecentCounter {
    Queue<Integer> q;

    public RecentCounter() {
        q = new LinkedList<>();
    }
    
    public int ping(int t) {
        q.add(t);

       
        while (q.peek() < t - 3000) {
            q.poll();
        }

        return q.size();
    }
}
