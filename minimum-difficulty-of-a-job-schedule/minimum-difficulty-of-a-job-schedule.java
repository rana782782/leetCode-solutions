// LeetCode: Minimum Difficulty of a Job Schedule (minimum-difficulty-of-a-job-schedule)
// Submission ID: 1703901949
// Language: java
// Timestamp (UTC): 2025-07-19T18:04:04Z

class Solution {

    static HashMap<String, Integer> map;

    public static int solution(int idx, int currMax, int d, int[] arr) {
        if (d == 1) {
            int max = 0;
            for (int i = idx; i < arr.length; i++) {
                max = Math.max(max, arr[i]);
            }
            return max;
        }

        if (idx >= arr.length - d + 1) return Integer.MAX_VALUE;

        String code = idx + "_" + d;
        if (map.containsKey(code)) return map.get(code);

        int max = 0, ans = Integer.MAX_VALUE;

        for (int i = idx; i <= arr.length - d; i++) {
            max = Math.max(max, arr[i]);
            int next = solution(i + 1, 0, d - 1, arr);
            if (next != Integer.MAX_VALUE) {
                ans = Math.min(ans, max + next);
            }
        }

        map.put(code, ans);
        return ans;
    }

    public int minDifficulty(int[] jobDifficulty, int d) {
        if (jobDifficulty.length < d) return -1;

        map = new HashMap<>();
        return solution(0, 0, d, jobDifficulty);
    }
}
