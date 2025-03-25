// LeetCode: The Number of Beautiful Subsets (the-number-of-beautiful-subsets)
// Submission ID: 1585935570
// Language: java
// Timestamp (UTC): 2025-03-25T17:41:54Z

class Solution {
    public static boolean canAdd(ArrayList<Integer> subAns, int ele, int k) {
        for (int i : subAns) {
            if (Math.abs(i - ele) == k) return false;
        }
        return true;
    }

    public static int solution(int nums[], int idx, int k, ArrayList<Integer> subAns) {
        if (idx >= nums.length) return 1; // Include the current subset (even empty)

        int ans = 0;

        // Option 1: Include nums[idx] if valid
        if (canAdd(subAns, nums[idx], k)) {
            subAns.add(nums[idx]);
            ans += solution(nums, idx + 1, k, subAns);
            subAns.remove(subAns.size() - 1);
        }

        // Option 2: Skip nums[idx]
        ans += solution(nums, idx + 1, k, subAns);

        return ans;
    }

    public int beautifulSubsets(int[] nums, int k) {
        ArrayList<Integer> subAns = new ArrayList<>();
        return solution(nums, 0, k, subAns) - 1; // Subtract 1 to exclude the empty subset
    }
}
