// LeetCode: Consecutive Characters (consecutive-characters)
// Submission ID: 1383313209
// Language: java
// Timestamp (UTC): 2024-09-08T14:55:06Z

class Solution {
    public int maxPower(String s) {
        int max_power = 0;
        int length = 1;
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i) == s.charAt(i-1)){
                length++;
            } else {
                max_power = Math.max(length, max_power);
                length = 1;
            }
        }
        return Math.max(length, max_power);
    }
}