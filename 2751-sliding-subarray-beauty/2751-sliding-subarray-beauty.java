import java.util.*;

class Solution {
    public static int get(TreeMap<Integer,Integer> map, int x) {

        int count = 0;
        // ⚠️ You must consider frequencies, not just keys
        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            count += entry.getValue(); // count all occurrences
            if (count >= x) { // when we reach the x-th smallest number
                return entry.getKey() < 0 ? entry.getKey() : 0;
            }
        }
        return 0;
    }

    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int n = nums.length;
        int output[] = new int[n - k + 1];
        int idx = 0;

        TreeMap<Integer,Integer> map = new TreeMap<>();

        int j = 0;
        // ⚠️ Original bug: this skipped nums[0]
        // FIX: include first k-1 elements (correct loop condition)
        while (j < k - 1) {
            int ele = nums[j];
            map.put(ele, map.getOrDefault(ele, 0) + 1);
            j++;
        }

        int i = 0;
        // ⚠️ Also ensure we don't go out of bounds when incrementing j inside loop
        while (j < nums.length) {
            // acquire new element
            int ele = nums[j];
            map.put(ele, map.getOrDefault(ele, 0) + 1);

            // compute x-th smallest
            int minEle = get(map, x);
            output[idx++] = minEle;

            // release old element
            int removeEle = nums[i];
            map.put(removeEle, map.get(removeEle) - 1);
            if (map.get(removeEle) == 0) map.remove(removeEle);

            // slide window
            i++;
            j++;
        }

        return output;
    }

    // Optional: test main
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {-1, -2, -3, -4, -5};
        int k = 2, x = 2;
        System.out.println(Arrays.toString(sol.getSubarrayBeauty(nums, k, x)));
    }
}
