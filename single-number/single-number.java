// LeetCode: Single Number (single-number)
// Submission ID: 1646455152
// Language: java
// Timestamp (UTC): 2025-05-27T22:05:50Z

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