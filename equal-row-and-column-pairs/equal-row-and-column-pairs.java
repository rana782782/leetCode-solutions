// LeetCode: Equal Row and Column Pairs (equal-row-and-column-pairs)
// Submission ID: 1595484479
// Language: java
// Timestamp (UTC): 2025-04-03T11:17:57Z

import java.util.*;

class Solution {
    public int equalPairs(int[][] grid) {
        Map<String, Integer> rowMap = new HashMap<>();
        int n = grid.length;
        
        // Store row representations in HashMap
        for (int[] row : grid) {
            String key = Arrays.toString(row);
            rowMap.put(key, rowMap.getOrDefault(key, 0) + 1);
        }

        int output = 0;
        
        // Construct column keys and compare with rowMap
        for (int j = 0; j < n; j++) {
            int[] colArr = new int[n];
            for (int i = 0; i < n; i++) {
                colArr[i] = grid[i][j];
            }
            String colKey = Arrays.toString(colArr); // Ensure same format as row keys

            // If column matches a row pattern, add occurrences
            if (rowMap.containsKey(colKey)) {
                output += rowMap.get(colKey);
            }
        }
        
        return output;
    }
}
