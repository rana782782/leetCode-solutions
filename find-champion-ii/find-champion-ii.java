// LeetCode: Find Champion II (find-champion-ii)
// Submission ID: 1594464303
// Language: java
// Timestamp (UTC): 2025-04-02T14:07:20Z

class Solution {
    public int findChampion(int n, int[][] edges) {
        int degree[] = new int[n];

        Arrays.fill(degree,0);

        for(int e[] : edges){
            degree[e[1]]++;
        }

        int zeroCount = 0;
        int output  = 0;

        for(int i = 0; i<degree.length; i++){
            if(zeroCount>1)return -1;

            if(degree[i] == 0){
                zeroCount++;
                output = i;
            }
        }

        return zeroCount>1 ? -1 : output;
    }
}