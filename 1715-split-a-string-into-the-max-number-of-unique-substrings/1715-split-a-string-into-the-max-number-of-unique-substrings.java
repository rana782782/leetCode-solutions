class Solution {
    public static int solution(int idx, String s, HashSet<String> set){
        if(idx>=s.length()) return 0;

        int ans = 0;

        for(int i = 1; i+idx<=s.length(); i++){
            
            String first = s.substring(idx,idx+i);

            if(!set.contains(first)){
                    set.add(first);
                    ans = Math.max(ans,1+solution(idx+i,s,set));
                    set.remove(first);
            }
        }

        return ans;
    }
    public int maxUniqueSplit(String s) {
        HashSet<String> set = new HashSet<>();

        return solution(0,s,set);
    }
}