// LeetCode: Subsets (subsets)
// Submission ID: 1690036856
// Language: java
// Timestamp (UTC): 2025-07-07T20:12:45Z

class Solution {
    static List<List<Integer>>output;
    public static void solution(int idx, int nums[], List<Integer>subAns){
        
        if(idx == nums.length){
            output.add(new ArrayList<>(subAns));
            return;
        }
        
        subAns.add(nums[idx]);
        solution(idx+1,nums,subAns);
        subAns.remove(subAns.size()-1);
        solution(idx+1,nums,subAns);
    }
    public List<List<Integer>> subsets(int[] nums) {
        
        output = new ArrayList<>();
        
        solution(0,nums,new ArrayList<>());
        return output;
    }
}