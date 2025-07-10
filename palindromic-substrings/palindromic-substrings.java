// LeetCode: Palindromic Substrings (palindromic-substrings)
// Submission ID: 1692691548
// Language: java
// Timestamp (UTC): 2025-07-10T04:21:41Z

class Solution {
    public static boolean isPalindrome(int start, int end, String str){
        while(start<end){
            if(str.charAt(start)!=str.charAt(end))return false;
            start++;
            end--;
        }
        
        return true;
    }
    public int countSubstrings(String s) {
        
        int count = 0;
        
        for(int start = 0; start<s.length(); start++){
            for(int end = start; end<s.length(); end++){
                if(isPalindrome(start,end,s))count++;
            }
        }
        
        return count;
    }
}