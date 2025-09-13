// LeetCode: Smallest Absent Positive Greater Than Average (smallest-absent-positive-greater-than-average)
// Submission ID: 1769385721
// Language: java
// Timestamp (UTC): 2025-09-13T14:42:31Z

class Solution {
    public int smallestAbsent(int[] nums) {
        HashSet<Integer>set = new HashSet<>();

        double avg = 0;

        for(int ele : nums){
            set.add(ele);
            avg+=ele;
        }

        avg = avg/nums.length;

        int i = (int)avg+1>0 ? (int)avg+1 : 1;

        for(int j= i; i<=10001; j++){
            if(!set.contains(j))return j;
        }

        return 0;
    }
}