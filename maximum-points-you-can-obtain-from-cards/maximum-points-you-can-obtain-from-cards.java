// LeetCode: Maximum Points You Can Obtain from Cards (maximum-points-you-can-obtain-from-cards)
// Submission ID: 1708560156
// Language: java
// Timestamp (UTC): 2025-07-23T14:00:49Z

class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int output = Integer.MIN_VALUE;
        int leftSum = 0;
        int rightSum = 0;

        int leftIdx = 0;
         int rightIdx = cardPoints.length-1;

         while(leftIdx<k){
            leftSum+=cardPoints[leftIdx];
            leftIdx++;
         }


         output = Math.max(output,leftSum+rightSum);
         leftIdx--;

         while(leftIdx>=0){
            leftSum-=cardPoints[leftIdx--];
            rightSum+=cardPoints[rightIdx--];

            output = Math.max(output,leftSum+rightSum);


         }

         return output;
    }
}