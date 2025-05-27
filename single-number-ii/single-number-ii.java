// LeetCode: Single Number II (single-number-ii)
// Submission ID: 1646456439
// Language: java
// Timestamp (UTC): 2025-05-27T22:09:00Z

class Solution {
    public int singleNumber(int[] nums) {
        HashMap<Integer,Integer>map = new HashMap<>();

        for(int ele : nums){
            map.put(ele,map.getOrDefault(ele,0)+1);
        }
        
        for(int ele : map.keySet()){
            if(map.get(ele) == 1)return ele;
        }

        return -1;


    
    }
}