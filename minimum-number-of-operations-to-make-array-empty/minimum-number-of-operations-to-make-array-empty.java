// LeetCode: Minimum Number of Operations to Make Array Empty (minimum-number-of-operations-to-make-array-empty)
// Submission ID: 1597523413
// Language: java
// Timestamp (UTC): 2025-04-05T14:16:31Z

class Solution {
    public int minOperations(int[] nums) {
        HashMap<Integer,Integer>map = new HashMap<>();

        for(int num : nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }

        int maxFreq = Collections.max(map.values());

        int dp[] = new int[maxFreq+1];

        Arrays.fill(dp,Integer.MAX_VALUE);

        dp[0] = 0;

        if(maxFreq>=2)dp[2] = 1;
        if(maxFreq>=3)dp[3] = 1;

        for(int i = 4; i<=maxFreq; i++){

            if(dp[i-2]!=Integer.MAX_VALUE){
                dp[i] = Math.min(dp[i],1+dp[i-2]);
            }

            if(dp[i-3]!=Integer.MAX_VALUE){
                dp[i] = Math.min(dp[i],1+dp[i-3]);
            }
        }

        int ans = 0;

        for(int val : map.values()){
            if(val == 1) return -1;
            else{
                ans+=dp[val];
            }
        }

        return ans;
    
    }
}