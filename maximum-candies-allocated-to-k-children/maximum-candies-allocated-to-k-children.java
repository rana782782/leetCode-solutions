// LeetCode: Maximum Candies Allocated to K Children (maximum-candies-allocated-to-k-children)
// Submission ID: 1672266047
// Language: java
// Timestamp (UTC): 2025-06-22T04:59:16Z

class Solution {
    public static boolean isPossible(long div,int arr[], long k){

        long count = 0;

        for(int ele : arr){
            count+=ele/div;
        }

        return count>=k;
    }
    public int maximumCandies(int[] candies, long k) {
        long low = 1;
        long high = Integer.MIN_VALUE;
        long sum = 0;

        for(int ele : candies){
            high = Math.max(high,ele);
            sum+=ele;
        }

        if(sum<k)return 0;

        long ans = 0;

         

         while(low<=high){
            long mid = low+(high-low)/2;

            if(isPossible(mid,candies,k)){
                 ans = mid;
                low = mid+1;
            }
            else{
                high = mid-1;
            }
         }

         return (int)ans;
    }
}