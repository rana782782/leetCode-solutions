class Solution {
    static int mod = 1000000007;

    public static int solution(int idx, int ele, HashMap<Integer,List<Integer>> map){
        List<Integer> subList = map.get(2 * ele);
        if (subList == null) return 0;

        int n = subList.size();

      
        int l = 0, r = n;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (subList.get(mid) >= idx) r = mid;
            else l = mid + 1;
        }
        int left = l;  

       
        l = 0; r = n;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (subList.get(mid) > idx) r = mid;
            else l = mid + 1;
        }
        int right = n - l;  

        return (int)((1L * left * right) % mod);
    }

    public int specialTriplets(int[] nums) {
        HashMap<Integer,List<Integer>> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int ele = nums[i];
            List<Integer> subList = map.getOrDefault(ele, new ArrayList<>());
            subList.add(i);       
            map.put(ele, subList);
        }

        int output = 0;

        for (int i = 1; i < nums.length - 1; i++) {
            int temp = solution(i, nums[i], map);
            output = (output + temp) % mod;
        }

        return output;
    }
}
