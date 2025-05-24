// LeetCode: Leftmost Column with at Least a One (leftmost-column-with-at-least-a-one)
// Submission ID: 1642920343
// Language: java
// Timestamp (UTC): 2025-05-24T10:48:48Z

/**
 * // This is the BinaryMatrix's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface BinaryMatrix {
 *     public int get(int row, int col) {}
 *     public List<Integer> dimensions {}
 * };
 */

class Solution {
    static int output;

     public static void getIdx(int low, int high, BinaryMatrix mat,int row){
            while(low<=high){
                int mid = low+((high-low)/2);
             int currEle = mat.get(row,mid);

             if(currEle == 1){
                output = Math.min(output,mid);
                high = mid-1;
             }
             else if(currEle>1){
                high = mid-1;
             }
             else{
                low = mid+1;
             }
            }
        }
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        output = Integer.MAX_VALUE;



        List<Integer>dim = binaryMatrix.dimensions();
        int m = dim.get(0);
         int n = dim.get(1);

         for(int i = 0; i<m; i++){
           getIdx(0,n-1,binaryMatrix,i);
           if(output == 0)return output;
         }

         return output == Integer.MAX_VALUE ? -1 : output;

    }
}