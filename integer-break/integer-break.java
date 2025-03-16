// LeetCode: Integer Break (integer-break)
// Submission ID: 1575543802
// Language: java
// Timestamp (UTC): 2025-03-16T10:23:25Z

class Solution {
   static HashMap<String,Integer>map;
	
	 public static int solution(int currNum,int k){
	        if(currNum<0) return Integer.MIN_VALUE;
	        if(currNum == 0 && k>=2) return 1;
	        
	        String key = currNum+"_"+k;
	        
	        if(map.containsKey(key))return map.get(key);

	        int maxi = Integer.MIN_VALUE;

	        for(int i = 1; i<=currNum; i++){

	            int ans = i*solution(currNum-i,k+1);

	            maxi = Math.max(ans,maxi);
	        }
            map.put(key, maxi);
	        return maxi;
	    }
    public int integerBreak(int n) {
        map = new HashMap<>();
        return solution(n,0);
    }
}