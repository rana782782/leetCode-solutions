// LeetCode: Find Missing and Repeated Values (find-missing-and-repeated-values)
// Submission ID: 1564629835
// Language: java
// Timestamp (UTC): 2025-03-06T07:25:55Z

class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        HashSet<Integer>set = new HashSet<>();

        int n = grid.length;
        n= n*n;
        int sigma = n*(n+1)/2;
        int actual_sum = 0;
        int repeated = 0;

        for( int arr[] : grid){
            for(int i = 0; i<arr.length; i++){
                if(set.contains(arr[i])) repeated = arr[i];
                else{
                    set.add(arr[i]);
                }

                actual_sum+=arr[i];
            }
        }

        System.out.println(sigma);

        System.out.println(actual_sum);


        int delta = sigma-actual_sum;
        int missing = delta+repeated;

        int output[] = {repeated,missing};
        return output;
    }
}