class Solution {
    public static int[] findDiv(int nums){
        int diff = Integer.MAX_VALUE;
        int x = 0;
        int y = 0;
         for(int i = 1; i*i<=nums; i++){
                if(nums%i == 0){
                    

                    int curr_diff = Math.abs((nums/i)-i);
                    if(curr_diff<diff){
                        diff = curr_diff;
                        x = i;
                        y = nums/i;
                    }
                }
         }
         int output[] = {x,y,diff};
         return output;
    }
    public int[] closestDivisors(int num) {
        int ans1[] = findDiv(num+1);
        int ans2[] = findDiv(num+2);

        if(ans1[2]<=ans2[2]){
            int output[] = {ans1[0],ans1[1]};
            return output;
        }

        int output[] = {ans2[0],ans2[1]};
        return output;
    }
}