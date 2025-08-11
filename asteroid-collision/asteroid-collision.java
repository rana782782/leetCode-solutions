// LeetCode: Asteroid Collision (asteroid-collision)
// Submission ID: 1731350153
// Language: java
// Timestamp (UTC): 2025-08-11T14:56:45Z

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer>st = new Stack<>();
        int i = 0;

        for(int ele : asteroids){
            if(ele<0){
                boolean destroyed = false;

                while(!st.isEmpty() && st.peek()>0){
                    if(st.peek()<Math.abs(ele))st.pop();
                    else if(st.peek() == Math.abs(ele)){
                        destroyed = true;
                        st.pop();
                        break;
                    }
                    else{
                        destroyed = true;
                        break;
                    }
                }
                if(!destroyed)st.push(ele);
            }
            else{
                st.push(ele);
            }
        }

        if(st.size() == 0)return new int[0];

        int output[] = new int[st.size()];

        int idx = st.size()-1;

        while(!st.isEmpty()){
            output[idx--] = st.pop();
        }

        return output;
    }
}