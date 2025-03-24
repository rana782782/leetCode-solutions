// LeetCode: Count Days Without Meetings (count-days-without-meetings)
// Submission ID: 1584026494
// Language: java
// Timestamp (UTC): 2025-03-24T05:55:23Z

class Solution {
    public int countDays(int days, int[][] meetings) {
        int sum = 0;

        Arrays.sort(meetings,(a,b)->Integer.compare(a[0],b[0]));

        int lastDay = meetings[0][1];

        for(int i = 1; i<meetings.length; i++){
          
          if(meetings[i][0]>lastDay){
            sum+=meetings[i][0]-lastDay-1;
          }

          lastDay = Math.max(lastDay,meetings[i][1]);
        }

        System.out.println(sum);
        if(meetings[0][0]>1){
            sum+=meetings[0][0]-1;
        }

        if(lastDay<days){
            sum+=days-lastDay;
        }

        return sum;


    }
}