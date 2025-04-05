// LeetCode: Maximum 69 Number (maximum-69-number)
// Submission ID: 1597435863
// Language: java
// Timestamp (UTC): 2025-04-05T12:14:27Z

class Solution {
     public int maximum69Number (int num) {
        StringBuilder sb = new StringBuilder(String.valueOf(num));

        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '6') {
                sb.setCharAt(i, '9');
                return Integer.valueOf(sb.toString());
            }
        }

        return num;
    }
}