// LeetCode: Find the Celebrity (find-the-celebrity)
// Submission ID: 1691324435
// Language: java
// Timestamp (UTC): 2025-07-08T22:15:01Z

/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        int inDegree[] = new int[n];
        
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                if(i!=j){
                    if(knows(i,j)){
                        inDegree[i]--;
                        inDegree[j]++;
                    }
                }
            }
        }
        
        int count = 0;
        int ans = -1;
        for(int i = 0; i<n; i++){
            if(inDegree[i] == n-1){
                count++;
                if(count>1)return -1;
                ans = i;
                
            }
        }
        
        return ans;
    }
}