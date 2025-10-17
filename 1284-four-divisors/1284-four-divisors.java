class Solution {
    public static int divisors(int n){
        int count = 1;
        int sum = 1;
        for(int i = 2; i<=n; i++){
             if(n%i == 0){
                count++;
                sum+=i;
             }
                if(count>4)break;
        }
        if(count == 4){
            System.out.println(sum);
             return sum;
        }

        return 0;
    }
    public int sumFourDivisors(int[] nums) {
        HashMap<Integer,Integer>map = new HashMap<>();

            int output =0;
        for(int ele : nums){
            if(map.containsKey(ele))output+=map.get(ele);
            else{
               int sum = divisors(ele);
               map.put(ele,sum);
               output+=sum;
            }

           
        }

         return output;
    }
}