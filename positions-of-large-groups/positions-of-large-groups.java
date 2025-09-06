// LeetCode: Positions of Large Groups (positions-of-large-groups)
// Submission ID: 1761260362
// Language: java
// Timestamp (UTC): 2025-09-06T08:23:39Z

class Solution {
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>>output = new ArrayList<>();

        int count = 1;

        int i = 0;
        while(i<s.length()-1){
            char ch = s.charAt(i);
            if(ch == s.charAt(i+1)){
                count++;
            }
            else{
                if(count>=3){
                    int startIdx = i-count+1;
                    List<Integer>subAns = new ArrayList<>();
                    subAns.add(startIdx);
                    subAns.add(i);
                    output.add(subAns);
                }
                count = 1;
            
            }
            i++;
        }

          if(count>=3){
                    int startIdx = s.length()-count;
                    List<Integer>subAns = new ArrayList<>();
                    subAns.add(startIdx);
                    subAns.add(s.length()-1);
                    output.add(subAns);
                }

        for(List<Integer>l : output){
            System.out.println(l.get(0)+"_"+l.get(1));
        }

        return output;
    }
}