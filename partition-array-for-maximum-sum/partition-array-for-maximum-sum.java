// LeetCode: Partition Array for Maximum Sum (partition-array-for-maximum-sum)
// Submission ID: 1583342618
// Language: java
// Timestamp (UTC): 2025-03-23T13:44:55Z

class Solution {
    static int memo[];

    public static int solution(int arr[], int idx, int k) {
        if (idx == arr.length) return 0;

        if (memo[idx] != -1) return memo[idx];

        int output = 0;
        int currMax = 0;

        for (int i = 0; i < k && idx + i < arr.length; i++) {
            currMax = Math.max(currMax, arr[idx + i]);
            int ans = (i + 1) * currMax + solution(arr, idx + i + 1, k);
            output = Math.max(output, ans);
        }

        return memo[idx] = output;
    }

    public int maxSumAfterPartitioning(int[] arr, int k) {
        memo = new int[arr.length];
        Arrays.fill(memo, -1);
        return solution(arr, 0, k);
    }
}
