class Solution {
    public int kthFactor(int n, int k) {
        if(k == 1)return 1;
        int curr_k = 1;
        int ans = 1;
        for(int i = 2; i<=n; i++){
            if(n%i == 0){
                curr_k+=1;
                if(curr_k == k){
                    ans = i;
                    break;

                }
            }
        }

        return curr_k == k ? ans : -1;
    }
}