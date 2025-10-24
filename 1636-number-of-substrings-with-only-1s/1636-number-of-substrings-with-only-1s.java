class Solution {
    public int numSub(String s) {
        int MOD = 1_000_000_007;
        long output = 0;
        int i = 0, j = 0;
        int n = s.length();

        while (i < n) {
            if (s.charAt(i) == '0') {
                long len = i - j;
                output = (output + len * (len + 1) / 2) % MOD;
                i++;
                j = i;
            } else {
                i++;
            }
        }

       
        long len = i - j;
        output = (output + len * (len + 1) / 2) % MOD;

        return (int) output;
    }
}
