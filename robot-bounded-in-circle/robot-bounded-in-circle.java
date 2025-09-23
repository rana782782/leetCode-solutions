// LeetCode: Robot Bounded In Circle (robot-bounded-in-circle)
// Submission ID: 1779930701
// Language: java
// Timestamp (UTC): 2025-09-23T07:37:47Z

class Solution {
    public boolean isRobotBounded(String instructions) {
        int idx = 0;
        int dir[][] = {{0,1},{1,0},{0,-1},{-1,0}};

        int x = 0;
        int y = 0;

        for(char ch : instructions.toCharArray()){
                if(ch == 'R'){
                    idx = (idx+1)%4;

                }
                else if(ch == 'L'){
                    idx = (idx+3)%4;
                }
                else{
                    x+=dir[idx][0];
                    y+=dir[idx][1];
                }
        }

        return (x == 0 && y == 0)||(idx!=0);
    }
}