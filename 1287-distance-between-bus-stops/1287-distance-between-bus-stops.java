class Solution {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int totalSum = 0;

        for(int ele : distance){
            totalSum+=ele;
        }

        int curr_sum = 0;

        for(int i = Math.min(start,destination); i<=Math.max(start-1,destination-1); i++){
            curr_sum+=distance[i];
        }

        return Math.min(totalSum-curr_sum,curr_sum);
    }
}