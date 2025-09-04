// LeetCode: Peak Index in a Mountain Array (peak-index-in-a-mountain-array)
// Submission ID: 1758929735
// Language: java
// Timestamp (UTC): 2025-09-04T04:33:13Z

class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int left = 1; 
        int right = arr.length - 2; 
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                return mid;
            } else if (arr[mid] < arr[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1; 
    }
}
