// LeetCode: Remove Duplicates from Sorted Array (remove-duplicates-from-sorted-array)
// Submission ID: 1718283891
// Language: java
// Timestamp (UTC): 2025-07-31T12:09:31Z

class Solution {
    public int removeDuplicates(int[] nums) {
        HashSet<Integer>set = new HashSet<>();
   
    int swapIdx = 0;

    for(int i = 0; i<nums.length; i++){
        int ele = nums[i];

        if(!set.contains(ele)){
            nums[swapIdx] = ele;
            set.add(ele);
            swapIdx++;
        }
    }

    return set.size();


    }
}