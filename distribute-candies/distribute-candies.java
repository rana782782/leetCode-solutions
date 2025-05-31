// LeetCode: Distribute Candies (distribute-candies)
// Submission ID: 1649891315
// Language: java
// Timestamp (UTC): 2025-05-31T16:16:35Z

class Solution {
    public int distributeCandies(int[] candyType) {
        int size = candyType.length;
        
        int diffType = size/2;
        
        HashSet<Integer>set = new HashSet<>();
        
        for(int ele : candyType){
            set.add(ele);
        }
        
        
        int availDiff = set.size();
        
        return diffType>=availDiff ? availDiff : diffType;
    }
}