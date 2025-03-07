// LeetCode: Closest Prime Numbers in Range (closest-prime-numbers-in-range)
// Submission ID: 1565690096
// Language: java
// Timestamp (UTC): 2025-03-07T06:37:31Z

class Solution {

 
    public int[] closestPrimes(int left, int right) {
        if(right<=2){
            int output[] = {-1,-1};
            return output;
        }

        boolean composite[] = new boolean[right+1];

        for(int i = 2; i*i<=right; i++){
            if(composite[i] == false){

                for(int j = i*i; j<=right; j+=i){
                      composite[j] = true;
                }
            }
        }

       
      int output[] = new int[2];
      output[0] = -1;
      output[1]  = -1;

        int diff = Integer.MAX_VALUE;
        int prev = -1;
        if(left == 1)left+=1;
        for(int i = left; i<=right; i++){
            if(composite[i] == false){
                if(prev == -1) prev = i;

                else{
                    int currDiff = i-prev;
                    if(currDiff<diff){
                        diff = currDiff;
                        output[0] = prev;
                        output[1] = i;
                    }

                    prev = i;
                }
            }
        }
      return output;
    }
}