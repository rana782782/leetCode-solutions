// LeetCode: Minimum Common Value (minimum-common-value)
// Submission ID: 1589989202
// Language: java
// Timestamp (UTC): 2025-03-29T11:57:37Z

class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        int i = 0;
         int j = 0;

         while(i<nums1.length && j<nums2.length){

            if(nums1[i] == nums2[j]) return nums1[i];

            else if(nums1[i]<nums2[j])i++;
            else{
                j++;
            }
         }

         return -1;
    }
}