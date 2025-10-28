class Solution {
    public static int find(int arr[], int k){
            int sum = 0;
            int i = 0;
            while(i<k-1){
                sum+=arr[i];
                i++;
            }
           
          int  j = 0;
          int output = 0;

          while(i<arr.length){
                sum+=arr[i];
                output+=sum;
                sum-=arr[j];
                i++;
                j++;
          }

            System.out.println(output);
          return output;

    }
    public int sumOddLengthSubarrays(int[] arr) {
        int output = 0;
        int k = 3;
        while(k<=arr.length){
            output+=find(arr,k);
            k+=2;
        }

        for(int ele : arr)output+=ele;

        return output;
    }
}