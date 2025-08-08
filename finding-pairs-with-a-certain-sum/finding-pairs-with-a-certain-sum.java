// LeetCode: Finding Pairs With a Certain Sum (finding-pairs-with-a-certain-sum)
// Submission ID: 1727840092
// Language: java
// Timestamp (UTC): 2025-08-08T10:25:48Z

class FindSumPairs {
    HashMap<Integer,Integer>map1;
    HashMap<Integer,Integer>map2;
    int arr[];

    public FindSumPairs(int[] nums1, int[] nums2) {
        map1 = new HashMap<>();
        map2 = new HashMap<>();
        arr = new int[nums2.length];

        for(int ele : nums1){
            map1.put(ele,map1.getOrDefault(ele,0)+1);
        }

        for(int i = 0; i<nums2.length; i++){
            int ele = nums2[i];
            arr[i] = ele;
            map2.put(ele,map2.getOrDefault(ele,0)+1);
        }
    }
    
    public void add(int index, int val) {
        int prevOne = arr[index];
        map2.put(prevOne,map2.get(prevOne)-1);
        if(map2.get(prevOne) == 0)map2.remove(prevOne);

        arr[index]+=val;

        int currOne = arr[index];
        map2.put(currOne,map2.getOrDefault(currOne,0)+1);
    }
    
    public int count(int tot) {
        int count = 0;

        for(int ele : map1.keySet()){
            if(ele<=tot){
                if(map2.containsKey(tot-ele))count+=map1.get(ele)*map2.get(tot-ele);
            }
        }

        return count;
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */