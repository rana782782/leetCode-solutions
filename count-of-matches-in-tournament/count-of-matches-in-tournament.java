// LeetCode: Count of Matches in Tournament (count-of-matches-in-tournament)
// Submission ID: 1580182684
// Language: java
// Timestamp (UTC): 2025-03-20T11:44:56Z

class Solution {

    public static int solution(int n){
        if(n<2) return 0;

        if(n == 2) return 1;


        int ans1 = 0;
         int ans2 = 0;

         if(n%2 == 0){
            ans1 = n/2+solution(n/2);
         }

         else{
            int quo = n/2;
            int rem = n-quo;

            ans2 = quo+solution(rem);
         }
         return ans1+ans2;
    }
    public int numberOfMatches(int n) {
         return solution(n);
    }
}