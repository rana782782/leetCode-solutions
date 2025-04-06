// LeetCode: Longest Palindrome After Substring Concatenation I (longest-palindrome-after-substring-concatenation-i)
// Submission ID: 1597936312
// Language: java
// Timestamp (UTC): 2025-04-06T00:24:17Z

class Solution {
   public static boolean isPalindrome(String str) {
		if(str.length() == 1) return true;
		
		int i = 0;
		 int j = str.length()-1;
		 
		 while(i<j) {
			 if(str.charAt(i)!=str.charAt(j)) return false;
			 i++;
			 j--;
		 }
		 
		 return true;
	}
	
	 public static int longestPalindrome(String s, String t) {
	        ArrayList<String>l1 = new ArrayList<>();
	        ArrayList<String>l2 = new ArrayList<>();
	        
	        for(int i = 0; i<s.length(); i++) {
	        	for(int j = i+1; j<=s.length(); j++) {
	        		String str = s.substring(i,j);
	        		l1.add(str);
	        		System.out.println(str);
	        	}
	        }
	        
	        for(int i = 0; i<t.length(); i++) {
	        	for(int j = i+1; j<=t.length(); j++) {
	        		String str = t.substring(i,j);
	        		l2.add(str);
	        		System.out.println(str);
	        	}
	        }
	        
	        int output = 0;
	        for(String str1 : l1) {
	        	if(isPalindrome(str1))output = Math.max(output, str1.length());
	        	for(String str2 : l2) {
	        		
	        		
	        		if(isPalindrome(str2))output = Math.max(output, str2.length());
	        		
	        		String n = str1+str2;
	        		
	        		if(isPalindrome(n))output = Math.max(output, n.length());
	        	}
	        }
	        
	        return output;
	    }

}