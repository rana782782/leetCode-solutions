// LeetCode: Numbers With Same Consecutive Differences (numbers-with-same-consecutive-differences)
// Submission ID: 1774877037
// Language: java
// Timestamp (UTC): 2025-09-18T10:39:47Z

class Solution {
    static int N,K;
    static List<Integer>output;
    public static void solution(int curr_len,int prev,int num){
            if(curr_len == N){
                System.out.println(num);
                output.add(num);
                return;
            }



        for(int i = 0; i<=9; i++){
            if(Math.abs(prev-i) == K){
                solution(curr_len+1,i,num*10+i);
            }
        }
    }
    public int[] numsSameConsecDiff(int n, int k) {
        N = n;
        K = k;
        output = new ArrayList<>();


        for(int i = 1; i<=9; i++){
            solution(1,i,i);
        }

        int size = output.size();

        int idx = 0;
        int ans[] = new int[size];
        for(int ele : output){
            ans[idx++] = ele;
        }
        return ans;
    }
}