// LeetCode: Best Meeting Point (best-meeting-point)
// Submission ID: 1691412782
// Language: java
// Timestamp (UTC): 2025-07-09T01:55:49Z

class Solution {
    public int minTotalDistance(int[][] grid) {
        List<Integer> rows = new ArrayList<>();
        List<Integer> cols = new ArrayList<>();

        int m = grid.length, n = grid[0].length;

        // Collect rows
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (grid[i][j] == 1)
                    rows.add(i);

        // Collect cols
        for (int j = 0; j < n; j++)
            for (int i = 0; i < m; i++)
                if (grid[i][j] == 1)
                    cols.add(j);

        int rowMedian = getMinDistanceMedian(rows);
        int colMedian = getMinDistanceMedian(cols);

        int dist = 0;
        for (int r : rows) dist += Math.abs(r - rowMedian);
        for (int c : cols) dist += Math.abs(c - colMedian);

        return dist;
    }

    private int getMinDistanceMedian(List<Integer> list) {
        Collections.sort(list);
        int n = list.size();
        if (n % 2 == 1) return list.get(n / 2);

        // Try both middle values and return the one with minimum total distance
        int left = list.get(n / 2 - 1), right = list.get(n / 2);
        int distLeft = 0, distRight = 0;
        for (int val : list) {
            distLeft += Math.abs(val - left);
            distRight += Math.abs(val - right);
        }
        return distLeft <= distRight ? left : right;
    }
}
