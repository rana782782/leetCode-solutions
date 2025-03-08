// LeetCode: Uncrossed Lines (uncrossed-lines)
// Submission ID: 1566757306
// Language: java
// Timestamp (UTC): 2025-03-08T07:31:29Z

class Solution {
    static int memo[][];
    public static int solution(HashMap<Integer,ArrayList<Integer>>map, int nums2[], int idx,int lastIdx){
        
        if(idx==nums2.length){
          
            return 0;
        }

    if(memo[idx][lastIdx+1]!=-1) return memo[idx][lastIdx+1];
        int ele = nums2[idx];
        int connected =0;
        if(map.containsKey(ele)){
           
            for(int corrIdx : map.get(ele)){

           if(corrIdx>lastIdx){
            connected = Math.max(connected,1+solution(map,nums2,idx+1,corrIdx));
        }
            }   
          
        }
    
           int notConnected = solution(map,nums2,idx+1,lastIdx);

           return memo[idx][lastIdx+1] = Math.max(connected,notConnected);

    }
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
        memo = new int[nums2.length+1][nums1.length+1];

      for(int i = 0; i<memo.length; i++){
        Arrays.fill(memo[i],-1);
      }


        for(int i = 0; i<nums1.length; i++){
            if(map.containsKey(nums1[i]))map.get(nums1[i]).add(i);

            else{
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(nums1[i],list);
            }
        }

       
        return solution(map,nums2,0,-1);
       
    }
}