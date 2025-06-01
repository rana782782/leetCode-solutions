// LeetCode: Longest Unequal Adjacent Groups Subsequence I (longest-unequal-adjacent-groups-subsequence-i)
// Submission ID: 1650547224
// Language: java
// Timestamp (UTC): 2025-06-01T08:58:43Z

class Solution {
    static int max_length = Integer.MIN_VALUE;
    static List<Integer> best;
    static HashMap<String,Integer>map;

    public static void solution(int idx, int prev, int[] groups, int currLength, List<Integer> subAns) {
        if (idx >= groups.length) {
            if (currLength > max_length) {
                max_length = currLength;
                best = new ArrayList<>(subAns);
            }
            return;
        }
        String code = idx+"_"+prev;
        if(map.containsKey(code) && map.get(code)>=currLength)return;
        map.put(code,currLength);

        if (prev != groups[idx]) {
            subAns.add(idx);
            solution(idx + 1, groups[idx], groups, currLength + 1, subAns);
            subAns.remove(subAns.size() - 1);
        }

        solution(idx + 1, prev, groups, currLength, subAns);

        
    }

    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        max_length = Integer.MIN_VALUE;
        best = new ArrayList<>();
        List<Integer> subAns = new ArrayList<>();
        map = new HashMap<>();

        solution(0, -1, groups, 0, subAns);

        List<String> output = new ArrayList<>();
        for (int idx : best) {
            output.add(words[idx]);
        }

        return output;
    }
}
