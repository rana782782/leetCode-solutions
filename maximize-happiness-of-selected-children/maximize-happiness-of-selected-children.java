// LeetCode: Maximize Happiness of Selected Children (maximize-happiness-of-selected-children)
// Submission ID: 1598876701
// Language: java
// Timestamp (UTC): 2025-04-06T19:36:04Z

class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        long output = 0;
        int count = 0;

        Arrays.sort(happiness);

        int i = happiness.length-1;

        while(k!=0){
            if(happiness[i]-count>0){
                output+=happiness[i]-count;
                count++;
            }
            else{
                break;
            }
            k--;
            i--;
        }

        return output;
    }
}