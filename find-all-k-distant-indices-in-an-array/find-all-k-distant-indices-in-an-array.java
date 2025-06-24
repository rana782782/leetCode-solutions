// LeetCode: Find All K-Distant Indices in an Array (find-all-k-distant-indices-in-an-array)
// Submission ID: 1675211107
// Language: java
// Timestamp (UTC): 2025-06-24T17:49:25Z

class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer>output = new ArrayList<>();
        Queue<Integer>q = new LinkedList<>();
        int n = nums.length;
        boolean visited[] = new boolean[n];

     for(int i = 0; i<nums.length; i++){
        if(nums[i] == key)q.add(i);
     }

        while(k>=0 && !q.isEmpty()){
            int size = q.size();

            while(size-->0){
                int i = q.poll();
                if(visited[i])continue;
                visited[i] = true;
                output.add(i);

                if(i-1>=0 && !visited[i-1])q.add(i-1);
                if(i+1<n && !visited[i+1])q.add(i+1);
            }
            k--;
        }
        Collections.sort(output);
        System.out.println(output);
        return output;
    }
}