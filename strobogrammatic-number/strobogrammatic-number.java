// LeetCode: Strobogrammatic Number (strobogrammatic-number)
// Submission ID: 1653092020
// Language: java
// Timestamp (UTC): 2025-06-03T21:04:21Z

class Solution {
    public boolean isStrobogrammatic(String num) {
        HashMap<Integer,Integer>map = new HashMap<>();
        map.put(0,0);
        map.put(1,1);
        map.put(6,9);
        map.put(8,8);
        map.put(9,6);
        int n = num.length();

        
        for(int i = 0; i<=n/2; i++){
            int ch1 = num.charAt(i)-'0';
            int ch2 = num.charAt(n-i-1)-'0';
            
            if(map.containsKey(ch1)){
                if(map.get(ch1)!=ch2)return false;
            }
            else{
                return false;
            }
        }
        
        return true;
    }
}