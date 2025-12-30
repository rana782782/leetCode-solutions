class Solution {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        int output[] = new int[k];

        HashMap<Integer,Set<Integer>>map = new HashMap<>();

        for(int arr[] : logs){
            int user = arr[0];
            int time = arr[1];

            Set<Integer>set = map.getOrDefault(user,new HashSet<>());
            set.add(time);
            map.put(user,set);
        }


        for(int key : map.keySet()){
            int idx = map.get(key).size();
            output[idx-1]++;
        }

        return output;
    }
}