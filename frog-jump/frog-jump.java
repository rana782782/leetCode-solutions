// LeetCode: Frog Jump (frog-jump)
// Submission ID: 1582185962
// Language: java
// Timestamp (UTC): 2025-03-22T10:41:18Z

class Solution {
    static int lastStone;
    static HashMap<String,Boolean> map;

    public static boolean solution(int currStone, int lastStep, HashSet<Integer>available){
      if(currStone == lastStone) return true;

      String key = currStone+"_"+lastStep;

      if(map.containsKey(key)) return map.get(key);

    boolean ans1 = false;
    boolean ans2 = false;
    boolean ans3 = false;  

    

    if(lastStep-1>0 && available.contains(currStone+lastStep-1)) ans1 = solution(currStone+lastStep-1,lastStep-1,available);

    if(available.contains(currStone+lastStep)) ans2 = solution(currStone+lastStep,lastStep,available);
    if(available.contains(currStone+lastStep+1)) ans3 = solution(currStone+lastStep+1,lastStep+1,available);

        boolean output = ans1||ans2||ans3;
        map.put(key,output);
    return output;
    }
    public boolean canCross(int[] stones) {

        if(stones[1]!=1) return false;
        map = new HashMap<>();


        lastStone = stones[stones.length-1];

        HashSet<Integer> set = new HashSet<>();

        for(int i : stones){
            set.add(i);
        }

        return solution(1,1,set);
        
    }
}