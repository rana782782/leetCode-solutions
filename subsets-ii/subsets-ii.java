// LeetCode: Subsets II (subsets-ii)
// Submission ID: 1647540981
// Language: java
// Timestamp (UTC): 2025-05-29T02:52:38Z

class Solution {
    static List<List<Integer>>output;

    public static void solution(int idx,int nums[],List<Integer>subAns){
        output.add(new ArrayList<>(subAns));

        for(int i = idx; i<nums.length; i++){
                if(i>idx && nums[i] == nums[i-1])continue;

                subAns.add(nums[i]);
                solution(i+1,nums,subAns);
                subAns.remove(subAns.size()-1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        output = new ArrayList<>();
        Arrays.sort(nums);

        List<Integer>subAns = new ArrayList<>();

        solution(0,nums,subAns);

        return output;
    }
}