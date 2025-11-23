class Solution {

    public static long solution(int n){
        StringBuilder temp = new StringBuilder();


        int sum = 0;

        while(n!=0){
            int rem = n%10;
            if(rem!=0){
                temp.append(rem);
                sum+=rem;
            }

            n/=10;
        }

        temp = temp.reverse();
        int num = Integer.parseInt(temp.toString());

        return (long)num*sum;
    }
    public long sumAndMultiply(int n) {
        if(n == 0)return 0;

        return solution(n);
    }
}