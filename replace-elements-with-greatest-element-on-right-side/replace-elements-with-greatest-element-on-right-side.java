// LeetCode: Replace Elements with Greatest Element on Right Side (replace-elements-with-greatest-element-on-right-side)
// Submission ID: 1484433625
// Language: java
// Timestamp (UTC): 2024-12-21T10:41:47Z

class Solution {
  public int[] replaceElements(int[] arr) {
    int n = arr.length;
    if (n == 1) {
        arr[0] = -1;
        return arr;
    }
    
    int maxRight = -1; // Initialize the maximum element to the right
    for (int i = n - 1; i >= 0; i--) {
        int current = arr[i];
        arr[i] = maxRight;
        if (current > maxRight) {
            maxRight = current; // Update the maximum element
        }
    }
    
    return arr;
}

}