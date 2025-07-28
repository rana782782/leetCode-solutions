// LeetCode: Count Good Numbers (count-good-numbers)
// Submission ID: 1714547067
// Language: java
// Timestamp (UTC): 2025-07-28T13:17:45Z

class Solution {

    public int countGoodNumbers(long n) {
        int mod = 1000000007;

        long evenPositions = (n + 1) / 2; // digits at even indices: 0, 2, 4... => 5 choices
        long oddPositions = n / 2;        // digits at odd indices: 1, 3, 5... => 4 choices

        long evenPow = power(5, evenPositions, mod);
        long oddPow = power(4, oddPositions, mod);

        return (int)((evenPow * oddPow) % mod);
    }

    // Modular exponentiation: (base^exp) % mod
  private long power(long base, long exp, int mod) {
    long result = 1;
    while (exp > 0) {
        if (exp % 2 == 1) result = (result * base) % mod;
        base = (base * base) % mod;
        exp /= 2;
    }
    return result;
}

}
