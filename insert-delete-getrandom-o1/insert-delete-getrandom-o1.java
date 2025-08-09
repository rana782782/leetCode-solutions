// LeetCode: Insert Delete GetRandom O(1) (insert-delete-getrandom-o1)
// Submission ID: 1728860380
// Language: java
// Timestamp (UTC): 2025-08-09T10:49:19Z

import java.util.*;

class RandomizedSet {
    List<Integer> subList;
    Map<Integer, Integer> map;
    int size;

    public RandomizedSet() {
        subList = new ArrayList<>();
        map = new HashMap<>();
        size = 0;
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) return false;
        subList.add(val);
        map.put(val, size);
        size++;
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;

        int idxToRemove = map.get(val);
        int lastElement = subList.get(size - 1);

        // Swap element with last
        subList.set(idxToRemove, lastElement);
        map.put(lastElement, idxToRemove);

        // Remove last element
        subList.remove(size - 1);
        map.remove(val);

        size--;
        return true;
    }

    public int getRandom() {
        int idx = (int)(Math.random() * size);
        return subList.get(idx);
    }
}
