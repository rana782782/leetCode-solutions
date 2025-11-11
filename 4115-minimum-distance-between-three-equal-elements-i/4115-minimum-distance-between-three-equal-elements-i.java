class Solution {

    public static int solution(List<Integer>subList){
        int output = Integer.MAX_VALUE;

        int i = 0;
         int j = 1;
          int k = 2;

          while(k<subList.size()){
            int dist = Math.abs(subList.get(i)-subList.get(j))+Math.abs(subList.get(j)-subList.get(k))+Math.abs(subList.get(k)-subList.get(i));
            output = Math.min(output,dist);
            i++;
            j++;
            k++;
          }

          return output;
    }
    public int minimumDistance(int[] nums) {
        HashMap<Integer,List<Integer>>map = new HashMap<>();

        for(int i = 0; i<nums.length; i++){
            List<Integer>subList = map.getOrDefault(nums[i],new ArrayList<>());
            subList.add(i);
            map.put(nums[i],subList);
        }

        int output = Integer.MAX_VALUE;

        for(List<Integer>subList : map.values()){
            if(subList.size()>=3){
                output = Math.min(output,solution(subList));
            }
        }

        return output == Integer.MAX_VALUE ? -1 : output;
    }
}