// LeetCode: Maximum Score After Splitting a String (maximum-score-after-splitting-a-string)
// Submission ID: 1580361034
// Language: java
// Timestamp (UTC): 2025-03-20T15:09:48Z

class Solution {
   	 public static int maxScore(String s) {
	        int zero[] = new int[s.length()];
	        
	        if(s.charAt(0)-'0' == 0) zero[0] = 1;
	        else {
	        	zero[0] = 0;
	        }
	        
	        
	        for(int i = 1; i<s.length(); i++) {
	        	int digit = s.charAt(i)-'0';
	        	
	        	if(digit == 0) zero[i] = 1+zero[i-1];
	        	else {
	        		zero[i] = zero[i-1];
	        	}
	        			
	        }
	        
	        
	        int one[] = new int[s.length()];
	        
	        if(s.charAt(s.length()-1)-'0' == 1) one[one.length-1] = 1;
	        else {
	        	one[one.length-1] = 0;
	        }
	        
	        
	        for(int i = s.length()-2; i>=0; i--) {
	        	int digit = s.charAt(i)-'0';
	        	
	        	if(digit == 1)one[i] = 1+one[i+1];
	        	else {
	        		one[i] = one[i+1];
	        	}
	        }
	        
	        int output = Integer.MIN_VALUE;
	        
	        
	        for(int i = 0; i<zero.length-1; i++) {
	        	int currSum = zero[i]+one[i+1];
	        	
	        	output = Math.max(currSum, output);
	        }
	        
	        return output;
	    }
}