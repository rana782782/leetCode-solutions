// LeetCode: Rotate String (rotate-string)
// Submission ID: 1651025912
// Language: java
// Timestamp (UTC): 2025-06-01T19:12:30Z

class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length()!=goal.length())return false;
        
        if(s.equals(goal))return true;
        
        StringBuilder temp = new StringBuilder(s);
        
        int steps = goal.length();
        
        while(steps-->0){
            char ch = temp.charAt(0);
            temp.deleteCharAt(0);
            
            temp.append(ch);
            
            if(goal.equals(temp.toString()))return true;
        }
        
        return false;
        
    }
}