// LeetCode: Number of Valid Subarrays (number-of-valid-subarrays)
// Submission ID: 1732349534
// Language: java
// Timestamp (UTC): 2025-08-12T11:11:04Z

class Solution {
    public int validSubarrays(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];

        Stack<Integer>st = new Stack<>();
        for(int i = nums.length-1; i>=0; i--){
            int ele = nums[i];
            while(!st.isEmpty() && nums[st.peek()]>=ele){
                st.pop();
            }
             
            dp[i] = st.size() == 0 ? n : st.peek();
            st.push(i);
        }

        int output = 0;
        for(int i = 0; i<n; i++){
            
            output+=(dp[i]-i);
        }

        return output;
    }
}