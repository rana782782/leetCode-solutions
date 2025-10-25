class Solution {
    public int totalMoney(int n) {
        int output = 0;
        int curr_amt = 1;
        for(int i = 1; i<=n; i++){
            output+=curr_amt;
            curr_amt++;
            if(i%7 == 0){
                curr_amt  = 1;
                int addon = i/7;
                curr_amt+=addon;

            }
        }

        return output;
    }
}