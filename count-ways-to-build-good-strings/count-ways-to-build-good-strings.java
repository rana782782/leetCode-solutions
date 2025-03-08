// LeetCode: Count Ways To Build Good Strings (count-ways-to-build-good-strings)
// Submission ID: 1567070056
// Language: java
// Timestamp (UTC): 2025-03-08T14:39:10Z

class Solution {
    static int Z,O;
    static int L,H;
    static int MOD = 1000000007;
    static int memo[];

    public static int solve(int length){
        if(length>H) return 0;
     int ans = 0;
        if(length>=L){
            ans = 1;
        }
        if(memo[length]!=-1) return memo[length];
        int zero_added = solve(length+Z);
        int one_added = solve(length+O);

        return memo[length] = (ans+zero_added+one_added)%MOD;
    }
    public int countGoodStrings(int low, int high, int zero, int one) {
        L = low;
        H = high;
        Z = zero;
        O = one;
        memo = new int[high+1];
        Arrays.fill(memo,-1);

        return solve(0);
    }
}