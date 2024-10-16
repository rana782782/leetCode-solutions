// LeetCode: Count Number of Ways to Place Houses (count-number-of-ways-to-place-houses)
// Submission ID: 1424069994
// Language: java
// Timestamp (UTC): 2024-10-16T08:23:21Z

class Solution {
    public int countHousePlacements(int n) {
        int oldBcount = 1;
        int oldScount = 1;
        int mod = 1000000007;

        for(int i = 2; i<=n; i++){
            int newScount = (oldBcount+oldScount)%mod;
            int newBcount = oldScount;
            oldBcount = newBcount;
            oldScount = newScount;
        }

        int ans = (oldBcount+oldScount)%mod;
        int output = (int)((long)ans*ans%mod);
        return output;
    }
}