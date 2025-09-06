// LeetCode: Consecutive Numbers Sum (consecutive-numbers-sum)
// Submission ID: 1761291991
// Language: java
// Timestamp (UTC): 2025-09-06T09:05:28Z

class Solution {
    public int consecutiveNumbersSum(int n) {
        int count = 0;
        for (long k = 1; k * (k - 1) / 2 < n; k++) {
            long remainder = n - k * (k - 1) / 2;
            if (remainder % k == 0) count++;
        }
        return count;
    }
}
