// LeetCode: Destination City (destination-city)
// Submission ID: 1580194825
// Language: java
// Timestamp (UTC): 2025-03-20T11:59:28Z

class Solution {
    public String destCity(List<List<String>> paths) {
        HashSet<String> set = new HashSet<>();
        
        for(List<String> subList : paths) {
        	set.add(subList.get(0));
        }
        
        
        for(List<String> subList : paths) {
        	  if(!set.contains(subList.get(1))) return subList.get(1);
        }
        
        return "";
    }
}