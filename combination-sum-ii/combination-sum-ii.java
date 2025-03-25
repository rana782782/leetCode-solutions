// LeetCode: Combination Sum II (combination-sum-ii)
// Submission ID: 1585995710
// Language: java
// Timestamp (UTC): 2025-03-25T18:27:47Z

class Solution {
    static HashSet<String> set;
    static List<List<Integer>> output;

    public static void solution(int idx, int nums[], int target, List<Integer> subAns, String psf, int currSum) {
        if (currSum == target) {
            if (!set.contains(psf)) {
                set.add(psf);
                output.add(new ArrayList<>(subAns));
            }
            return;
        }
        
        if (idx >= nums.length || currSum > target) return;

        // Skip duplicate elements to avoid duplicate subsets
        for (int i = idx; i < nums.length; i++) {
            if (i > idx && nums[i] == nums[i - 1]) continue;

            subAns.add(nums[i]);
            solution(i + 1, nums, target, subAns, psf + nums[i] + ",", currSum + nums[i]);
            subAns.remove(subAns.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        output = new ArrayList<>();
        set = new HashSet<>();
        List<Integer> subAns = new ArrayList<>();

        Arrays.sort(candidates);

        solution(0, candidates, target, subAns, "", 0);

        return output;
    }
}
