// LeetCode: Binary Subarrays With Sum (binary-subarrays-with-sum)
// Submission ID: 1771606699
// Language: java
// Timestamp (UTC): 2025-09-15T13:30:47Z

class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        HashMap<Integer,Integer>map = new HashMap<>();

        map.put(0,1);

        int currSum = 0;
        int output = 0;

        for(int ele : nums){
            currSum+=ele;
            
            
            if(map.containsKey(currSum-goal)){
                output+=map.get(currSum-goal);
            }

            map.put(currSum,map.getOrDefault(currSum,0)+1);
        }

        return output;
    }
}