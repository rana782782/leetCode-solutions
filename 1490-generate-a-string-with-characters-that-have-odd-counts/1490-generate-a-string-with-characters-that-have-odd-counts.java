class Solution {
    public static String even(int n){
        StringBuilder output = new StringBuilder();
         for(int i = 1; i<n; i++){
            output.append('a');
         }
         output.append('z');

         return output.toString();
    }

    public static String odd(int n){
        StringBuilder output = new StringBuilder();
        for(int i = 0; i<n; i++){
            output.append('a');
        }

        return output.toString();
    }
    public String generateTheString(int n) {
            if(n%2 ==0)return even(n);

            return odd(n);
    }
}