// LeetCode: Solving Questions With Brainpower (solving-questions-with-brainpower)
// Submission ID: 1592851973
// Language: java
// Timestamp (UTC): 2025-04-01T07:51:43Z

class Solution {
    static long memo[];

    public static long solve(int questions[][], int idx){
        if(idx>=questions.length) return 0;
        if(memo[idx]!=-1)return memo[idx];

        long taken = questions[idx][0]+solve(questions, idx+questions[idx][1]+1);
        long notTaken = solve(questions,idx+1);

        return memo[idx] = Math.max(taken,notTaken);
    }
    public long mostPoints(int[][] questions) {
        memo = new long[questions.length+1];

        Arrays.fill(memo,-1);
        return solve(questions,0);
    }
}