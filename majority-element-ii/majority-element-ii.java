// LeetCode: Majority Element II (majority-element-ii)
// Submission ID: 1651020707
// Language: java
// Timestamp (UTC): 2025-06-01T19:04:54Z

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        
        int req = n/3;
        
        HashMap<Integer,Integer>map = new HashMap<>();
        
        for(int ele : nums){
            map.put(ele,map.getOrDefault(ele,0)+1);
        }
        
        List<Integer>output = new ArrayList<>();
        
        for(int key : map.keySet()){
             
            int val = map.get(key);
            
            if(val>req)output.add(key);
        }
        
        return output;
    }
}