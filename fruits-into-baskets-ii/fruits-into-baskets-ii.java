// LeetCode: Fruits Into Baskets II (fruits-into-baskets-ii)
// Submission ID: 1722800498
// Language: java
// Timestamp (UTC): 2025-08-04T08:20:43Z

class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = baskets.length;
        int visited[] = new int[n];

        Arrays.fill(visited,-1);
        int count = 0;

        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                if(visited[j]==-1 && baskets[j]>=fruits[i]){
                    visited[j] = 1;
                    System.out.println(j+" ");
                    count++;
                    break;
                }
            }
        }

        return n-count;
    }
}