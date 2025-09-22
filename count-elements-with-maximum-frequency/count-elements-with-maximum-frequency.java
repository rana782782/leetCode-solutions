// LeetCode: Count Elements With Maximum Frequency (count-elements-with-maximum-frequency)
// Submission ID: 1778577440
// Language: java
// Timestamp (UTC): 2025-09-22T01:37:03Z

class Solution {
    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer,Integer>map = new HashMap<>();

        int maxFreq = 0;

        for(int ele : nums){
            map.put(ele,map.getOrDefault(ele,0)+1);

            maxFreq = Math.max(maxFreq,map.get(ele));
        }

        int res = 0;

        for(int freq : map.values()){
            if(freq == maxFreq)res+=freq;
        }

        return res;
    }
}