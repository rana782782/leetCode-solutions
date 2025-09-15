// LeetCode: Knight Dialer (knight-dialer)
// Submission ID: 1771624584
// Language: java
// Timestamp (UTC): 2025-09-15T13:48:33Z

class Solution {
    static int dir[][] = {{-2,1},{-1,2},{1,2},{2,1},{2,-1},{1,-2},{-1,-2},{-2,-1}};
    static int MOD = 1000000007;
    static HashMap<String,Integer> map;

    public static int solution(int i, int j, int n) {
        if (i < 0 || i > 3 || j < 0 || j > 2 || (i == 3 && j == 0) || (i == 3 && j == 2)) return 0;
        if (n == 0) return 1;

        String key = i + "_" + j + "_" + n;
        if (map.containsKey(key)) return map.get(key);

        int ans = 0;
        for (int[] d : dir) {
            int nRow = i + d[0];
            int nCol = j + d[1];
            ans = (ans + solution(nRow, nCol, n - 1)) % MOD;
        }

        map.put(key, ans);
        return ans;
    }

    public int knightDialer(int n) {
        if (n == 1) return 10; 

        int output = 0;
        map = new HashMap<>();

        for (int i = 0; i <= 3; i++) {
            for (int j = 0; j <= 2; j++) {
                if (i == 3 && (j == 0 || j == 2)) continue;
                output = (output + solution(i, j, n - 1)) % MOD;
            }
        }

        return output;
    }
}
