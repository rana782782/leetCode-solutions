// LeetCode: Optimal Partition of String (optimal-partition-of-string)
// Submission ID: 1598659297
// Language: java
// Timestamp (UTC): 2025-04-06T15:38:46Z

class Solution {
    public int partitionString(String s) {
        HashSet<Character>set = new HashSet<>();
        int count = 1;

        int idx = 0;

        while(idx<s.length()){
            char ch = s.charAt(idx);

            if(set.contains(ch)){
                set = new HashSet<>();
                set.add(ch);
                count++;
            }
            else{
                set.add(ch);
            }

            idx++;
        }

        return count;
    }
}