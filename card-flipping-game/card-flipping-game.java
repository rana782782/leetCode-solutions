// LeetCode: Card Flipping Game (card-flipping-game)
// Submission ID: 1758917647
// Language: java
// Timestamp (UTC): 2025-09-04T04:19:26Z

class Solution {
    public int flipgame(int[] fronts, int[] backs) {
        int n = fronts.length;
       HashSet<Integer>set = new HashSet<>();
       int output = 2001;

       for(int i =0; i<n; i++){
        if(fronts[i] == backs[i])set.add(fronts[i]);
       }

       for(int i = 0; i<n; i++){
                int num = fronts[i];
                if(!set.contains(num) && num<output)output = num;
       }
       for(int i = 0; i<n; i++){
                int num = backs[i];
                if(!set.contains(num) && num<output)output = num;
       }
        System.out.print(output);
       return output == 2001 ? 0 : output;
    }
}