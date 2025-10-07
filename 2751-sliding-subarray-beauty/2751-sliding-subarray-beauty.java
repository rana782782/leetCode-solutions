import java.util.*;

class Solution {
    public static int get(TreeMap<Integer,Integer> map, int x) {

        int count = 0;
        
        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            count += entry.getValue();
            if (count >= x) {
                return entry.getKey() < 0 ? entry.getKey() : 0;
            }
        }
        return 0;
    }

    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int n = nums.length;
        int output[] = new int[n - k + 1];
        int idx = 0;

        TreeMap<Integer,Integer> map = new TreeMap<>();

        int j = 0;
    
        while (j < k - 1) {
            int ele = nums[j];
            map.put(ele, map.getOrDefault(ele, 0) + 1);
            j++;
        }

        int i = 0;
       
        while (j < nums.length) {
          
            int ele = nums[j];
            map.put(ele, map.getOrDefault(ele, 0) + 1);

     
            int minEle = get(map, x);
            output[idx++] = minEle;

           
            int removeEle = nums[i];
            map.put(removeEle, map.get(removeEle) - 1);
            if (map.get(removeEle) == 0) map.remove(removeEle);

            i++;
            j++;
        }

        return output;
    }

   
}
