class Solution {
    static int memo[][];
    public static int solution(int idx, int nums[], int mod){
                if(idx == nums.length){
                    if(mod == 0)return 0;
                    return Integer.MIN_VALUE;
                }
            if(memo[idx][mod]!=-1)return memo[idx][mod];
        int ans1 = Integer.MIN_VALUE;
        int ans2 = Integer.MIN_VALUE;


        int temp1 = solution(idx+1,nums,(mod+nums[idx])%3);
        if(temp1!=Integer.MIN_VALUE)ans1 = temp1+nums[idx];

        int temp2 = solution(idx+1,nums,mod);
        if(temp2!=Integer.MIN_VALUE)ans2 = temp2;


        return memo[idx][mod] = Math.max(ans1,ans2);

    }
    public int maxSumDivThree(int[] nums) {
       
        memo = new int[nums.length][3];
        for(int d[] : memo){
                    Arrays.fill(d,-1);
        }
         int temp = solution(0,nums,0);

        return temp == Integer.MIN_VALUE ? 0 : temp;

    }
}