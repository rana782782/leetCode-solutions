// LeetCode: Tallest Billboard (tallest-billboard)
// Submission ID: 1570155991
// Language: java
// Timestamp (UTC): 2025-03-11T10:49:58Z

class Solution {
    static int memo[][];

    public static int solution(int rods[],int idx,int diff){
        if(idx>=rods.length){
            if(diff == 0) return 0;

            return Integer.MIN_VALUE;
        }
        if(memo[idx][diff+5000]!=-1) return memo[idx][diff+5000];
        int added_left =  rods[idx]+solution(rods,idx+1,diff+rods[idx]);
        int added_right = rods[idx]+solution(rods,idx+1,diff-rods[idx]);
        int not_added =   solution(rods,idx+1,diff);


        return memo[idx][diff+5000] = Math.max(Math.max(added_left,added_right),not_added);
    }
    public int tallestBillboard(int[] rods) {
        memo = new int[21][10001];
        for(int i = 0; i<memo.length; i++){
            Arrays.fill(memo[i],-1);
        }
        int output = solution(rods,0,0);
        return output/2;
    }
}