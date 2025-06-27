// LeetCode: How Many Numbers Are Smaller Than the Current Number (how-many-numbers-are-smaller-than-the-current-number)
// Submission ID: 1678097068
// Language: java
// Timestamp (UTC): 2025-06-27T08:36:19Z

class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        HashMap<Integer,Integer>map = new HashMap<>();
        
        int length = nums.length;
        
        int output[] = new int[length];
        
        for(int i = 0; i<nums.length; i++){
            if(map.containsKey(nums[i])){
                output[i] = map.get(nums[i]);
                continue;
            }
            
            int count = 0;
            
            for(int j = 0; j<nums.length; j++){
                if(j!=i && nums[j]<nums[i])count++;
            }
            
            output[i] = count;
            map.put(nums[i],count);
        }
        
        return output;
    }
}