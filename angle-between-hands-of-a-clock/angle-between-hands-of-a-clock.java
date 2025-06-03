// LeetCode: Angle Between Hands of a Clock (angle-between-hands-of-a-clock)
// Submission ID: 1653102065
// Language: java
// Timestamp (UTC): 2025-06-03T21:25:23Z

class Solution {
    public double angleClock(int hour, int minutes) {
        
        double mintAngle = minutes*6;
        double hrs = hour+((double)(minutes/60.00));
        
        double hrsAngle = hrs*30;
        
        double currAngle = Math.abs(hrsAngle-mintAngle);
        
        return Math.min(currAngle,360-currAngle);
    }
}