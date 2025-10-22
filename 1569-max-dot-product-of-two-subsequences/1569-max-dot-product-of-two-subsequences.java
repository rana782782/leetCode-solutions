class Solution {
    static int memo[][];
    public static int solution(int i, int j, int nums1[], int nums2[]) {
        if (i == nums1.length || j == nums2.length)
            return Integer.MIN_VALUE;

            if(memo[i][j]!=Integer.MAX_VALUE)return memo[i][j];

        int ans1 = Integer.MIN_VALUE;
        int ans2 = Integer.MIN_VALUE;
        int ans3 = Integer.MIN_VALUE;

        int prod = nums1[i] * nums2[j];

        int temp1 = solution(i + 1, j + 1, nums1, nums2);
        if (temp1 != Integer.MIN_VALUE)
            ans1 = prod + temp1;
        ans1 = Math.max(ans1, prod); 

        int temp2 = solution(i + 1, j, nums1, nums2);
        if (temp2 != Integer.MIN_VALUE)
            ans2 = temp2;

        int temp3 = solution(i, j + 1, nums1, nums2);
        if (temp3 != Integer.MIN_VALUE)
            ans3 = temp3;

        return memo[i][j] = Math.max(ans1, Math.max(ans2, ans3));
    }

    public int maxDotProduct(int[] nums1, int[] nums2) {
        memo = new int[nums1.length][nums2.length];
        for(int d[] : memo){
            Arrays.fill(d,Integer.MAX_VALUE);
        }
        return solution(0, 0, nums1, nums2);
    }
}
