class Solution {
    static int T;
    static double memo[][];
    public static double solution(int idx, double prob[],int head){
           if(idx == prob.length){
             return head == T ? 1.0 : 0.0;
           }
           if (head > T) return 0.0;

            if(memo[idx][head]!=-1)return memo[idx][head];
        double ans1 = prob[idx]*solution(idx+1,prob,head+1);
        double ans2 = (1-prob[idx])*solution(idx+1,prob,head);

        return memo[idx][head] = ans1+ans2;
                
                
    }
    public double probabilityOfHeads(double[] prob, int target) {
        T = target;
        memo = new double[prob.length+1][target+1];
        for(double d[] : memo){
            Arrays.fill(d,-1);
        }
        return solution(0, prob, 0);
    }
}