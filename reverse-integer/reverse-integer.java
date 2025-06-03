// LeetCode: Reverse Integer (reverse-integer)
// Submission ID: 1652925225
// Language: java
// Timestamp (UTC): 2025-06-03T17:02:34Z

class Solution {
    public int reverse(int x) {
        long n = x;  // use long to avoid overflow
        boolean negative = n < 0;
        n = Math.abs(n);

        long sum = 0;
        while (n != 0) {
            sum = sum * 10 + n % 10;
            n /= 10;
        }

        if (sum > Integer.MAX_VALUE) return 0;

        return negative ? (int)(-sum) : (int)sum;
    }
}
