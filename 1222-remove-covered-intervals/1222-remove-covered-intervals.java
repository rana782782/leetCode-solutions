class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
       Arrays.sort(intervals, (a, b) -> {
    if (a[0] == b[0]) 
        return Integer.compare(b[1], a[1]);
    return Integer.compare(a[0], b[0]);
});

        int count = 1;

        int lRange = intervals[0][0];
        int rRange = intervals[0][1];

        for(int i = 1; i<intervals.length; i++){

            int sPoint = intervals[i][0];
            int ePoint = intervals[i][1];

            if(sPoint<=rRange && ePoint<=rRange)continue;
            else{
                rRange = Math.max(rRange,ePoint);
                count++;
            }
        }

        return count;


    }
}