// LeetCode: Online Stock Span (online-stock-span)
// Submission ID: 1730584912
// Language: java
// Timestamp (UTC): 2025-08-10T21:37:06Z

class StockSpanner {
    ArrayList<Integer>arr;
    public StockSpanner() {
        arr = new ArrayList<>();
    }
    
    public int next(int price) {
        int ans = 1;
        for(int i = arr.size()-1; i>=0; i--){
            if(arr.get(i)>price)break;
            else{
                ans+=1;
            }
        }
        arr.add(price);
        return ans;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */