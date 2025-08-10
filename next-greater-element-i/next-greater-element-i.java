// LeetCode: Next Greater Element I (next-greater-element-i)
// Submission ID: 1730082400
// Language: java
// Timestamp (UTC): 2025-08-10T12:19:09Z

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer>map = new HashMap<>();
        Stack<Integer>st = new Stack<>();
        int ans[] = new int[nums1.length];

        for(int i = nums2.length-1; i>=0; i--){
                int ele = nums2[i];

                while(!st.isEmpty() && ele>st.peek()){
                    st.pop();
                }

                if(st.size() == 0){
                    map.put(ele,-1);
                }
                else{
                    map.put(ele,st.peek());
                }

                st.push(ele);
        }


        for(int i = 0; i<nums1.length; i++){
            ans[i] = map.get(nums1[i]);
        }

        return ans;
    }
}