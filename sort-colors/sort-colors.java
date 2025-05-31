// LeetCode: Sort Colors (sort-colors)
// Submission ID: 1649908853
// Language: java
// Timestamp (UTC): 2025-05-31T16:38:45Z

class Solution {
    public void sortColors(int[] nums) {
        TreeMap<Integer,Integer>map = new TreeMap<>();
        
        for(int ele : nums){
            map.put(ele,map.getOrDefault(ele,0)+1);
        }
        
        int idx = 0;
        int prevIdx =0;
        
     for(int key : map.keySet()){
         int steps = map.get(key);
         
        while(idx!=prevIdx+steps){
            nums[idx] = key;
            idx++;
        }
         
         prevIdx = idx;
         
     }
    }
}