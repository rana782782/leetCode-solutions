// LeetCode: Check if Number is a Sum of Powers of Three (check-if-number-is-a-sum-of-powers-of-three)
// Submission ID: 1562309452
// Language: java
// Timestamp (UTC): 2025-03-04T07:01:19Z

class Solution {
    static HashMap<Double,Boolean> map;
	public static boolean solution(int target, double d, String psf,boolean visited[]) {
		if(d>target) return false;
		
		if(d == target) {
			System.out.println(psf);
			return true;
		}
		
		
		if(map.containsKey(d)) return map.get(d);
		boolean ans = false;
		for(int i = 0; i<=16; i++) {
			if(!visited[i]) {
				visited[i] = true;
				ans = solution(target,d+Math.pow(3,i), psf+i+" ", visited);
				if(ans) return true;
				visited[i] = false;
				if(d>target) break;
			}
		}
		
		map.put(d,ans);
		return ans;
			
		
	}
    public boolean checkPowersOfThree(int n) {
        if(n == 1) return true;
        boolean visited[] = new boolean[17];
		Arrays.fill(visited, false);
        map = new HashMap<>();
        return solution(n,0,"",visited);
    }
}