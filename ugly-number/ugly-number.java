// LeetCode: Ugly Number (ugly-number)
// Submission ID: 1561350913
// Language: java
// Timestamp (UTC): 2025-03-03T11:22:49Z

class Solution {
    public boolean isUgly(int n) {
        if (n <= 0) return false;
    
    while (n % 2 == 0) n /= 2;
    while (n % 3 == 0) n /= 3;
    while (n % 5 == 0) n /= 5;

    return n == 1;

    }
}