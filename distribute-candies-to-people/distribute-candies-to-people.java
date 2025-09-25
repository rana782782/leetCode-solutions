// LeetCode: Distribute Candies to People (distribute-candies-to-people)
// Submission ID: 1782202297
// Language: java
// Timestamp (UTC): 2025-09-25T10:33:46Z

class Solution {
    public int[] distributeCandies(int candies, int num_people) {
        int output[] = new int[num_people];

        Arrays.fill(output,0);

        int idx = 0;
        int curr_can = 1;
        while(candies>0){
            if(curr_can>candies){
                output[idx%num_people]+= candies;
                break;
            }
            output[idx%num_people]+= curr_can;
            candies-=curr_can;
            curr_can++;
            idx++;
        }

        return output;
    }
}