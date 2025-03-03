// LeetCode: Maximum Profit in Job Scheduling (maximum-profit-in-job-scheduling)
// Submission ID: 1561502790
// Language: java
// Timestamp (UTC): 2025-03-03T14:30:42Z

class Solution {
    static int memo[] = new int[50001];
    	public class Pair implements Comparable<Pair>{
		int start;
		 int end;
		 int profit;
		 
		 Pair(int start, int end, int profit){
			 this.start = start;
			 this.end = end;
			 this.profit = profit;
		 }
		 
		 public int compareTo(Pair o) {
			 return this.start-o.start;
		 }

	}
	
	public static int solution(Pair arr[], int idx) {
		if(idx>=arr.length) return 0;
        if(memo[idx]!= -1) return memo[idx];
		
		int next = getIdx(arr,idx+1,arr[idx].end);
		
		int taken = arr[idx].profit+solution(arr, next);
		
		int notTaken = solution(arr, idx+1);
		
		return memo[idx] = Math.max(taken,notTaken);
	}

	private static int getIdx(Pair[] arr, int i, int target) {
		int left = i;
		 int right = arr.length-1;
		 int result = arr.length+1;
		 
		 while(left<=right) {
			 int mid = (left+right)/2;
			 
			 if(arr[mid].start>=target) {
				 result = mid;
				 right = mid-1;
			 }
			 
			 else {
				 left = mid+1;
			 }
		 }
		 
		 return result;
	}
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = profit.length;

        Pair arr[] = new Pair[n];

        for(int i = 0; i<n; i++){
            int st = startTime[i];
             int end = endTime[i];
             int prof = profit[i];

             arr[i] = new Pair(st,end,prof);
        }
        Arrays.sort(arr);
        Arrays.fill(memo,-1);

        return solution(arr,0);
    }
}