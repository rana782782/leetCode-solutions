// LeetCode: Smallest Subsequence of Distinct Characters (smallest-subsequence-of-distinct-characters)
// Submission ID: 1732318340
// Language: java
// Timestamp (UTC): 2025-08-12T10:34:59Z

class Solution {
    public String smallestSubsequence(String s) {
        HashMap<Character,Integer>map =new HashMap<>();
        HashSet<Character>set = new HashSet<>();
        Stack<Character>st = new Stack<>();

        for(char ch : s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }

        for(char ch : s.toCharArray()){
            map.put(ch,map.get(ch)-1);

            if(set.contains(ch))continue;

            while(!st.isEmpty() && st.peek()>ch && map.get(st.peek())>0){
                set.remove(st.pop());
            }

            st.add(ch);
            set.add(ch);
        }

        StringBuilder output = new StringBuilder();

        while(!st.isEmpty()){
            output.append(st.pop());
        }

        return output.reverse().toString();
    }
}