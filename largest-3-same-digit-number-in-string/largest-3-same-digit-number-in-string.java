// LeetCode: Largest 3-Same-Digit Number in String (largest-3-same-digit-number-in-string)
// Submission ID: 1580167925
// Language: java
// Timestamp (UTC): 2025-03-20T11:27:27Z

class Solution {
   public static String largestGoodInteger(String num) {
	        HashMap<Integer,Integer> map = new HashMap<>();
	        int prev = Integer.MIN_VALUE;
	        String output = "";
	        
	        for(int i = 0; i<3; i++) {
	        	int ch = num.charAt(i)-'0';
	        	
	        	map.put(ch,map.getOrDefault(ch,0)+1);
	        }
	        
	        if(map.size() == 1) {
	        	String subs = num.substring(0, 3);
	        	prev = Integer.parseInt(subs);
	        	output = subs;
	        }
	        
	        int i = 2;
	        int j = 0;
	        
	        while(i<num.length()-1) {
	        	i++;
	        	int aq = num.charAt(i)-'0';
	        	
	        	map.put(aq,map.getOrDefault(aq,0)+1);
	        	
	        	int del = num.charAt(j)-'0';
	        	j++;
	        	
	        	if(map.get(del) == 1) map.remove(del);
	        	else {
	        		map.put(del,map.get(del)-1);
	        	}
	        	
	        if(map.size() == 1) {
	        		String subs = num.substring(j,i+1);
	        	
	        		if(Integer.parseInt(subs)>prev) {
	        		prev = Integer.parseInt(subs);
	        		output = subs;
	        	}
	        }
	        }
	        
	        return output;
	    }
}