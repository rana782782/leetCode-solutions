// LeetCode: Count Number of Nice Subarrays (count-number-of-nice-subarrays)
// Submission ID: 1387749240
// Language: java
// Timestamp (UTC): 2024-09-12T14:25:18Z

class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int count = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int sum = 0;

        for(int i = 0; i<nums.length; i++){
            if(nums[i]%2 == 0){
                
                map.put(sum,map.getOrDefault(sum,0)+1);
            }
            else{
                sum+=1;
                map.put(sum,map.getOrDefault(sum,0)+1);
            }

            if(map.containsKey(sum-k)){
                count+=map.get(sum-k);
            }
        }

        return count;
    }
}