// LeetCode: Maximum Value of an Ordered Triplet I (maximum-value-of-an-ordered-triplet-i)
// Submission ID: 1594106660
// Language: java
// Timestamp (UTC): 2025-04-02T07:20:22Z

class Solution {
    static long output;
    public static void solution(int idx, int nums[], int k, List<Integer>subAns){
          if(k == 3){
           
            long curr = (long)(subAns.get(0)-subAns.get(1))*subAns.get(2);
            output = Math.max(output,curr);

            return;
        }
        if(idx>=nums.length) return;

      

        subAns.add(nums[idx]);
        solution(idx+1,nums,k+1,subAns);
        subAns.remove(subAns.size()-1);

        solution(idx+1,nums,k,subAns);
    }
    public long maximumTripletValue(int[] nums) {
        output = Long.MIN_VALUE;
        List<Integer>subAns = new ArrayList<>();

        solution(0,nums,0,subAns);

        return output<0 ? 0 : output;
    }
}