// LeetCode: Bulb Switcher (bulb-switcher)
// Submission ID: 1693825315
// Language: java
// Timestamp (UTC): 2025-07-11T04:14:12Z

class Solution {
    public int bulbSwitch(int n) {
        if(n == 0 || n == 1)return n;

        int ans = (int)Math.sqrt(n);

        return ans;
    }
}