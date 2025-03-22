// LeetCode: Minimum Changes To Make Alternating Binary String (minimum-changes-to-make-alternating-binary-string)
// Submission ID: 1582033643
// Language: java
// Timestamp (UTC): 2025-03-22T07:03:06Z

class Solution {
    public int minOperations(String s) {
        if(s.length() == 1) return 0;

        int zeroCase = 0;
        int oneCase = 0;

        for(int i = 0; i<s.length(); i++){
            int currNum = s.charAt(i)-'0';

            if(i%2 == 0 ){

                if(currNum == 1) zeroCase++;
                else{
                    oneCase++;
                }
            }
            else{
                if(currNum == 0) zeroCase++;

                else{
                    oneCase++;
                }
            }

        }

        return Math.min(zeroCase,oneCase);
    }
}