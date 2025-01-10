// LeetCode: Lemonade Change (lemonade-change)
// Submission ID: 1503787367
// Language: java
// Timestamp (UTC): 2025-01-10T06:47:21Z

class Solution {
    	public static int getChange(int x, int changes[]) {
		while(x>=10 && changes[10]!=0) {
			x-=10;
			changes[10]--;
		}
		
		while(x>=5 && changes[5]!=0) {
			x-=5;
			changes[5]--;
		}

        return x;
	}
	 public boolean lemonadeChange(int[] bills) {
	       int changes[] = new int[21];
	       
	       for(int i = 0; i<bills.length; i++) {
	    	   changes[bills[i]]++;
	    	   
	    	   int moneyToBeGiven = bills[i]-5;
	    	moneyToBeGiven=getChange(moneyToBeGiven, changes);
	    	   if(moneyToBeGiven!=0) return false;
	       }
	       
	       return true;
	    }
}