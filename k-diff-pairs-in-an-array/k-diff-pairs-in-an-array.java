// LeetCode: K-diff Pairs in an Array (k-diff-pairs-in-an-array)
// Submission ID: 1381373318
// Language: java
// Timestamp (UTC): 2024-09-06T18:23:24Z

 // O(n) Time Solution

 class Solution {
 		public int findPairs(int[] nums, int k) {
 			Map<Integer, Integer> map = new HashMap();
 			for (int num : nums)
 				map.put(num, map.getOrDefault(num, 0) + 1);

 			int result = 0;
 			for (int i : map.keySet())
 				if (k > 0 && map.containsKey(i + k) || k == 0 && map.get(i) > 1)
 					result++;
 			return result;
 		}
 	}