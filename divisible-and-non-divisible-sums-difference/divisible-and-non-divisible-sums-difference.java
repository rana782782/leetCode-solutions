// LeetCode: Divisible and Non-divisible Sums Difference (divisible-and-non-divisible-sums-difference)
// Submission ID: 1646178534
// Language: java
// Timestamp (UTC): 2025-05-27T16:03:04Z

class Solution {
    public int differenceOfSums(int n, int m) {
        int divSum = 0;

        for(int i = m; i<=n; i+=m){
            divSum+=i;
        }

        int totalSum = (n*(n+1))/2;

        return totalSum-2*divSum;
    }
}