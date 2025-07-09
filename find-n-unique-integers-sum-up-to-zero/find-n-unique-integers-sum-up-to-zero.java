// LeetCode: Find N Unique Integers Sum up to Zero (find-n-unique-integers-sum-up-to-zero)
// Submission ID: 1691374095
// Language: java
// Timestamp (UTC): 2025-07-09T00:25:16Z

class Solution {
    public int[] sumZero(int n) {
        if(n == 1)return new int[]{0};
        if(n == 2)return new int[]{1,-1};
        int output[] = new int[n];
        int num = n;
        int steps = n/2;
        int idx = 0;
        
        while(steps-->0){
            output[idx++] = -num;
            output[idx++] = num;
            num--;;
        }
        
      if(n%2 != 0)output[idx] = 0;
        
        return output;
    }
}