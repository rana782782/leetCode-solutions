// LeetCode: Maximal Network Rank (maximal-network-rank)
// Submission ID: 1594155503
// Language: java
// Timestamp (UTC): 2025-04-02T08:23:32Z

class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        int degree[] = new int[n];
        Arrays.fill(degree,0);

        HashSet<String> set = new HashSet<>();

        for(int p[] : roads){
            String key = p[0]+"_"+p[1];
            
            set.add(key);
            degree[p[0]]++;
            degree[p[1]]++;
        }
        int output = 0;
        for(int i = 0; i<n-1; i++){
            for(int j= i+1; j<n; j++){
                int sum = degree[i]+degree[j];
                String key = i+"_"+j;
                String key2 = j+"_"+i;
                if(set.contains(key) || set.contains(key2))sum-=1;
                output = Math.max(output,sum);
            }
        }

        return output;
    }
}