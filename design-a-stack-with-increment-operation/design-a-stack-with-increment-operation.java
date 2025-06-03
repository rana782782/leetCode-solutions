// LeetCode: Design a Stack With Increment Operation (design-a-stack-with-increment-operation)
// Submission ID: 1653120998
// Language: java
// Timestamp (UTC): 2025-06-03T22:09:20Z

class CustomStack {
static int arr[];
    static int idx;
    static int sz;
    public CustomStack(int maxSize) {
        arr = new int[maxSize];
        idx = -1;
        sz = maxSize;
    }
    
    public void push(int x) {
        if(idx<sz-1){
            idx++;
            arr[idx] = x;
           
        }
    }
    
    public int pop() {
        if(idx == -1)return -1;
        
        int output = arr[idx--];
        return output;
    }
    
    public void increment(int k, int val) {
            if(k<=idx){
                for(int i = 0; i<k; i++){
                    arr[i]+=val;
                }
            }
        else if(idx<k){
            for(int i = 0; i<=idx; i++){
                arr[i]+=val;
            }
         
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */