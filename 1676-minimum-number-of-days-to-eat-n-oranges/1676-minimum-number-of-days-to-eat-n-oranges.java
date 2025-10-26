import java.util.*;

class Solution {
    static Map<Integer, Integer> memo = new HashMap<>();

    public int minDays(int n) {
        if (n <= 1) return n;
        if (memo.containsKey(n)) return memo.get(n);
        int by2 = n % 2 + 1 + minDays(n / 2);
        int by3 = n % 3 + 1 + minDays(n / 3);

        int res = Math.min(by2, by3);
        memo.put(n, res);
        return res;
    }
}
