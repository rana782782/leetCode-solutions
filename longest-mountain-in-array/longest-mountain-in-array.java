// LeetCode: Longest Mountain in Array (longest-mountain-in-array)
// Submission ID: 1764846463
// Language: java
// Timestamp (UTC): 2025-09-09T11:19:19Z

class Solution {
    public static int expandLeft(int idx, int arr[]){
        int i = idx - 1;
        while (i >= 0 && arr[i] < arr[i + 1]) {
            i--;
        }
        return i + 1;
    }

    public static int expandRight(int idx, int arr[]){
        int i = idx + 1;
        while (i < arr.length && arr[i] < arr[i - 1]) {
            i++;
        }
        return i - 1;
    }

    public int longestMountain(int[] arr) {
        if (arr.length < 3) return 0;

        int maxLen = 0;

        for (int i = 1; i < arr.length - 1; i++) {
            // only try expansion if i is a peak
            if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                int left = expandLeft(i, arr);
                int right = expandRight(i, arr);
                maxLen = Math.max(maxLen, right - left + 1);
            }
        }

        return maxLen >= 3 ? maxLen : 0;
    }
}
