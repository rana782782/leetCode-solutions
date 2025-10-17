class Solution {
    public static boolean isPossible(int num, int arr[], int d){
        for(int ele : arr){
            if(Math.abs(num-ele)<=d)return false;
        }

        return true;
    }
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
         int count = 0;

         for(int ele : arr1){
            if(isPossible(ele, arr2, d))count++;
         }
         return count;
    }
}