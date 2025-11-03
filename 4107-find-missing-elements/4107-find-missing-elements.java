class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        HashSet<Integer>set = new HashSet<>();

        int mini =Integer.MAX_VALUE;
        int maxi = Integer.MIN_VALUE;


        for(int ele : nums){
            set.add(ele);
            mini = Math.min(ele,mini);
            maxi = Math.max(ele,maxi);
        }

        List<Integer>output = new ArrayList<>();
        for(int i = mini; i<=maxi; i++){
                    if(!set.contains(i))output.add(i);
        }

        return output;
    }
}