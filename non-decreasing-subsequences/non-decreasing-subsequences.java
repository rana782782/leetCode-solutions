// LeetCode: Non-decreasing Subsequences (non-decreasing-subsequences)
// Submission ID: 1586622491
// Language: java
// Timestamp (UTC): 2025-03-26T07:35:53Z

class Solution {
    static HashSet<List<Integer>>set;
    static List<List<Integer>> output;
    public static void solution(int idx, int nums[],List<Integer>subAns){
        if(idx>=nums.length){
            if(subAns.size()>=2){
                if(!set.contains(subAns)){
                    set.add(new ArrayList<>(subAns));
                    output.add(new ArrayList<>(subAns));
                }
            }

            return;
        }

      

        // if element is not added
        solution(idx+1,nums,subAns);

        //if element is added

        if(subAns.size() == 0 || nums[idx]>=subAns.get(subAns.size()-1)){
            subAns.add(nums[idx]);
            solution(idx+1,nums,subAns);
            subAns.remove(subAns.size()-1);
        }

    }
    public List<List<Integer>> findSubsequences(int[] nums) {
            set =  new HashSet<>();
            output = new ArrayList<>();
            List<Integer>subAns = new ArrayList<>();

            solution(0,nums,subAns);

            return output;
    }
}