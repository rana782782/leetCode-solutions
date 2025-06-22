// LeetCode: Magnetic Force Between Two Balls (magnetic-force-between-two-balls)
// Submission ID: 1672316420
// Language: java
// Timestamp (UTC): 2025-06-22T06:02:11Z

class Solution {

    public static boolean isPossible(int dist, int position[], int m){
        int count = 1;
        int prevDist = position[0];

        for(int i = 1; i<position.length; i++){
            if(position[i]-prevDist>=dist){
                count++;
                prevDist = position[i];
            }

            if(count>=m)return true;
        }

        return false;
    }
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);

        int low = 1;
        int high = position[position.length-1]-position[0];

        int ans = -1;

        while(low<=high){
            int mid = low+(high-low)/2;

            if(isPossible(mid,position,m)){
                ans = mid;
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }

        return ans;
    }
}