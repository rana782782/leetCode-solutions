import java.util.*;

class Solution {
    public int getWinner(int[] arr, int k) {
        
        if (k >= arr.length) {
            int max = Integer.MIN_VALUE;
            for (int ele : arr) max = Math.max(max, ele);
            return max;
        }

        Deque<Integer> dq = new ArrayDeque<>();
        for (int ele : arr) dq.addLast(ele);

        HashMap<Integer, Integer> map = new HashMap<>();

        while (true) {
            int first = dq.pollFirst();
            int second = dq.pollFirst();

            if (first > second) {
               
                dq.addFirst(first); 
                dq.addLast(second);

                map.put(first, map.getOrDefault(first, 0) + 1);
                map.put(second, 0); 
                if (map.get(first) == k) return first;
            } else {
                
                dq.addFirst(second);
                dq.addLast(first);

                map.put(second, map.getOrDefault(second, 0) + 1);
                map.put(first, 0);

                if (map.get(second) == k) return second;
            }
        }
    }
}
