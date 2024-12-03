// LeetCode: Longest Palindrome (longest-palindrome)
// Submission ID: 1469001942
// Language: java
// Timestamp (UTC): 2024-12-03T06:43:07Z

class Solution {
    public int longestPalindrome(String s) {
          HashMap<Character,Integer> map = new HashMap<>();
	        for(int i = 0; i<s.length(); i++) {
	        	char ch = s.charAt(i);
	        	map.put(ch, map.getOrDefault(ch,0)+1);
	        }
	        
	        int  ans = 0;
	        
	        for(int i = 0; i<s.length(); i++) {
	        	char ch = s.charAt(i);
	        	if(map.containsKey(ch)) {
	        		if(map.get(ch)>1) {
	        			ans+=2;
	        			if(map.get(ch) == 2) {
	        				map.remove(ch);
	        			}
	        			else {
	        				map.put(ch,map.get(ch)-2);
	        			}
	        			
	        		}
	        	}
	        }
	        
	        if(map.size()>=1) {
	        	ans=ans+1;
	        	return ans;
	        }
	        
	        return ans;
    }
}