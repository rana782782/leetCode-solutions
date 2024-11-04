// LeetCode: Pascal's Triangle II (pascals-triangle-ii)
// Submission ID: 1442751294
// Language: java
// Timestamp (UTC): 2024-11-04T13:14:37Z

class Solution {
    public List<Integer> getRow(int rowIndex) {
        int dp[][] = new int[rowIndex+1][rowIndex+1];
		List<List<Integer>> output = new ArrayList<>();
		
		for(int i = 0; i<dp.length; i++) {
			List<Integer> subAns = new ArrayList<>();
			for(int j = 0; j<=i; j++) {
				if((j == 0) ||(i == j)) {
					dp[i][j] = 1;
				}
				
				else {
					dp[i][j] = dp[i-1][j]+dp[i-1][j-1];
				}
				subAns.add(dp[i][j]);
			
			}
			output.add(subAns);
			
		}
	return	output.get(rowIndex);
    }
}