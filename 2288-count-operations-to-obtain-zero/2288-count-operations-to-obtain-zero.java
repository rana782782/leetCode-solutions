class Solution {
    public static int solution(int num1,int num2){
        if(num1 == 0 || num2 == 0)return 0;

        if(num1>=num2){
                num1-=num2;
                return 1+solution(num1,num2);
        }
        else{
            num2-=num1;
            return 1+solution(num1,num2);
        }
    }
    public int countOperations(int num1, int num2) {
        return solution(num1,num2);
    }
}