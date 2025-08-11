// LeetCode: 132 Pattern (132-pattern)
// Submission ID: 1731216133
// Language: java
// Timestamp (UTC): 2025-08-11T12:54:48Z

class Solution {
    public boolean find132pattern(int[] nums) {
        if (nums.length < 3) return false;

        TreeMap<Integer, Integer> map = new TreeMap<>();
        int minEle = nums[0];

        
        for (int k = 2; k < nums.length; k++) {
            map.put(nums[k], map.getOrDefault(nums[k], 0) + 1);
        }

        int j = 1;
        while (j < nums.length - 1) {
            if (minEle < nums[j]) {
                Integer justSmallerThanJ = map.lowerKey(nums[j]); 
                if (justSmallerThanJ != null && justSmallerThanJ > minEle) {
                    return true;
                }
            }

            minEle = Math.min(minEle, nums[j]);

           
            int nextVal = nums[j + 1];
            map.put(nextVal, map.get(nextVal) - 1);
            if (map.get(nextVal) == 0) {
                map.remove(nextVal);
            }

            j++;
        }

        return false;
    }
}
