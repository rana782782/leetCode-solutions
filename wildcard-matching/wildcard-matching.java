// LeetCode: Wildcard Matching (wildcard-matching)
// Submission ID: 1690123641
// Language: java
// Timestamp (UTC): 2025-07-07T23:02:59Z

class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        Boolean[][] dp = new Boolean[m + 1][n + 1];
        return match(0, 0, s, p, dp);
    }

    private boolean match(int i, int j, String s, String p, Boolean[][] dp) {
        if (dp[i][j] != null) return dp[i][j];

        // Base case: both strings exhausted
        if (i == s.length() && j == p.length()) return dp[i][j] = true;

        // If pattern exhausted but string not
        if (j == p.length()) return dp[i][j] = false;

        // If string exhausted but pattern still has chars
        if (i == s.length()) {
            for (int k = j; k < p.length(); k++) {
                if (p.charAt(k) != '*') return dp[i][j] = false;
            }
            return dp[i][j] = true;
        }

        char chS = s.charAt(i);
        char chP = p.charAt(j);

        if (chP == '*') {
            // '*' matches empty OR one character
            dp[i][j] = match(i + 1, j, s, p, dp) || match(i, j + 1, s, p, dp);
        } else if (chP == '?' || chS == chP) {
            dp[i][j] = match(i + 1, j + 1, s, p, dp);
        } else {
            dp[i][j] = false;
        }

        return dp[i][j];
    }
}
