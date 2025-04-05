// LeetCode: Broken Calculator (broken-calculator)
// Submission ID: 1597401051
// Language: java
// Timestamp (UTC): 2025-04-05T11:22:48Z

class Solution {
    public static int solution(int sv, int target){
        if(target<=sv){
            return sv-target;
        }

        if(target%2 == 0){
            return 1+solution(sv,target/2);
    }

    else{
        return 1+solution(sv,target+1);
    }
    }
    public int brokenCalc(int startValue, int target) {
        return solution(startValue,target);
    }
}