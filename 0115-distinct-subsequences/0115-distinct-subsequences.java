class Solution {
    static int m,n;
    static int memo[][];
    

    public static int solution(int idx1,int idx2,String s,String t){
            if(idx1 == m && idx2 == n)return 1;
            if(idx2 == n)return 1;
            if(idx1 == m)return 0;

            if(memo[idx1][idx2]!=-1)return memo[idx1][idx2];
        char ch1 = s.charAt(idx1);
        char ch2 = t.charAt(idx2);

        int ans1 = 0;
         int ans2 = 0;

         if(ch1 == ch2){
            ans1+=solution(idx1+1,idx2+1,s,t);
            ans2+=solution(idx1+1,idx2,s,t);
         }
         else{
            ans2+=solution(idx1+1,idx2,s,t);
         }

         return memo[idx1][idx2] = ans1+ans2;
    }
    public int numDistinct(String s, String t) {
        m = s.length();
        n = t.length();

        memo = new int[m][n];

        for(int d[] : memo){
            Arrays.fill(d,-1);
        }

        return solution(0,0,s,t);

    }
}