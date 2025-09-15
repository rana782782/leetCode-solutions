// LeetCode: Most Stones Removed with Same Row or Column (most-stones-removed-with-same-row-or-column)
// Submission ID: 1771948600
// Language: java
// Timestamp (UTC): 2025-09-15T18:27:37Z

class Solution {

    public static void dfs(int index, int stones[][], boolean visited[]){
        visited[index] = true;
        int row = stones[index][0];
         int col = stones[index][1];
        for(int i = 0; i<stones.length; i++){
            if(!visited[i] && (stones[i][0] == row || stones[i][1] == col)){
                dfs(i,stones,visited);
            }
        }
    }
    public int removeStones(int[][] stones) {
        int n = stones.length;

        boolean visited[] = new boolean[n];
        int grp = 0;
        for(int i = 0; i<stones.length; i++){
            if(!visited[i]){
                        dfs(i,stones,visited);
                        grp++;
            }
        }

        return n-grp;
    }
}