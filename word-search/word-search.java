// LeetCode: Word Search (word-search)
// Submission ID: 1714821645
// Language: java
// Timestamp (UTC): 2025-07-28T16:59:17Z

class Solution {
    static int m, n;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public boolean solution(int row, int col, int idx, char[][] board, String word, boolean[][] visited) {
        if (idx == word.length()) return true;

        if (row < 0 || row >= m || col < 0 || col >= n || visited[row][col] || board[row][col] != word.charAt(idx)) {
            return false;
        }

        visited[row][col] = true;

        for (int[] d : dir) {
            int nRow = row + d[0];
            int nCol = col + d[1];
            if (solution(nRow, nCol, idx + 1, board, word, visited)) {
                return true;
            }
        }

        visited[row][col] = false;
        return false;
    }

    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;

        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (solution(i, j, 0, board, word, visited)) {
                    return true;
                }
            }
        }

        return false;
    }
}
