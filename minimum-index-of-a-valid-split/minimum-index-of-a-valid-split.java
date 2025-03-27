// LeetCode: Minimum Index of a Valid Split (minimum-index-of-a-valid-split)
// Submission ID: 1587752972
// Language: java
// Timestamp (UTC): 2025-03-27T05:53:53Z

class Solution {
  	 public static class Pair{
	        int ele;
	         int freq;

	         Pair(int ele, int freq){
	            this.ele = ele;
	            this.freq = freq;
	         }

	         
	    }
	
	public static int minimumIndex(List<Integer> nums) {
        int left[] = new int[nums.size()];
        int right[] = new int[nums.size()];

        Arrays.fill(left,-1);
        Arrays.fill(right,-1);
        HashMap<Integer,Integer>map = new HashMap<>();
        Pair p = new Pair(-1,0);
        for(int i = 0; i<nums.size(); i++){
                int n = nums.get(i);

                map.put(n,map.getOrDefault(n,0)+1);

                if(map.get(n)>(i+1)/2){
                    p.ele = n;
                    p.freq = map.get(n);
                }

                if(p.freq>(i+1)/2){
                    left[i] = p.ele;
                }
        }

        map = new HashMap<>();
        p = new Pair(-1,0);

        for(int i = nums.size()-1; i>=0; i--){
                  int n = nums.get(i);

                map.put(n,map.getOrDefault(n,0)+1);

                if(map.get(n)>(nums.size()-i)/2){
                    p.ele = n;
                    p.freq = map.get(n);
                }

                if(p.freq>(nums.size()-i)/2){
                    right[i] = p.ele;
                }
        }
        
        for(int i = 0; i<left.length; i++) {
        	System.out.print(left[i]+" ");
        }
        
        System.out.println();
        for(int i =0; i<right.length; i++) {
        	System.out.print(right[i]+" ");
        }
        
        for(int i = 0; i<left.length-1; i++) {
        	if(left[i]!=-1 && right[i+1]!=-1 && left[i] == right[i+1])return i;
        }
        
        return -1;
    }

}