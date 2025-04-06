// LeetCode: Eliminate Maximum Number of Monsters (eliminate-maximum-number-of-monsters)
// Submission ID: 1598826415
// Language: java
// Timestamp (UTC): 2025-04-06T18:33:28Z

class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        double time[] = new double[dist.length];

        for(int i = 0;i<dist.length; i++){
            time[i] = (double)dist[i]/speed[i];
        }

        Arrays.sort(time);

        int count = 0;

        for(int i = 0; i<time.length; i++){
            if(time[i]>i)count++;

            else{
                break;
            }
        }

        return count;
    }
}