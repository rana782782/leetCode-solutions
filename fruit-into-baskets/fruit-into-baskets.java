// LeetCode: Fruit Into Baskets (fruit-into-baskets)
// Submission ID: 1722786443
// Language: java
// Timestamp (UTC): 2025-08-04T08:03:14Z

class Solution {
    public int totalFruit(int[] fruits) {
     
        int right = 0;
         int left = 0; 
         int ans = 0;
         HashMap<Integer,Integer> map = new HashMap<>();

         while(right<fruits.length){
            int aq = fruits[right];
            map.put(aq,map.getOrDefault(aq,0)+1);

            while(map.size()>2){
                int release = fruits[left];
                if(map.get(release) == 1){
                    map.remove(release);
                }
                else{
                    map.put(release,map.get(release)-1);
                }
                left++;
            }

            if(map.size()>=1){
      int length = right-left+1;
      ans = Math.max(ans,length);
            }
            right++;
         }
         return ans;

    }
}