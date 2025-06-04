// LeetCode: Range Sum Query - Immutable (range-sum-query-immutable)
// Submission ID: 1654077738
// Language: java
// Timestamp (UTC): 2025-06-04T19:16:48Z

class NumArray {
    
    static int arr[];

    public NumArray(int[] nums) {
        arr = nums.clone();
        
        int sum = 0;
        
        for(int i = 0; i<nums.length; i++){
            sum+=nums[i];
            arr[i] = sum;
        }
    }
    
    public int sumRange(int left, int right) {
        
        if(left>0)return arr[right]-arr[left-1];
        
        return arr[right];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */