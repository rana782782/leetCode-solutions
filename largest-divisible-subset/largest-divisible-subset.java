// LeetCode: Largest Divisible Subset (largest-divisible-subset)
// Submission ID: 1678126254
// Language: java
// Timestamp (UTC): 2025-06-27T09:12:47Z

class Solution {
    public static class Pair{
        int count;
        List<Integer>l;
        Pair(int count,List<Integer>l){
            this.count = count;
            this.l = l;
        }
    }
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        Pair dp[] = new Pair[n];
        Arrays.sort(nums);
        for(int i = 0; i<n; i++){
            dp[i] = new Pair(0,new ArrayList<>());
        }
        
        
        List<Integer>output = new ArrayList<>();
        
        for(int i = 0; i<n; i++){
            int count = 0;
            int idx = i;
            if(i>0){
                for(int j = i-1; j>=0; j--){
                    if(nums[i]%nums[j] ==0){
                       
                        if(dp[j].count>count){
                            count = dp[j].count;
                            idx = j;
                        }
                    }
                }
            }
            
            dp[i].count = count+1;
            List<Integer> subAns = new ArrayList<>(dp[idx].l); // safe copy
subAns.add(nums[i]); // now add the current element
dp[i].l = subAns;

            
            if(output.size()<dp[i].l.size()){
                output = new ArrayList<>(dp[i].l);
            }
        }
        
        return output;
    }
}