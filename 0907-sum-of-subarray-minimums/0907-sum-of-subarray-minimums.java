class Solution {
    public static int[] sol1(int arr[]){
        int n = arr.length;
        int output[] = new int[n];

        Stack<Integer>st = new Stack<>();

        for(int i = n-1; i>=0; i--){

            while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                st.pop();
            }

            if(st.isEmpty())output[i] = n;
            else output[i] = st.peek();

            st.push(i);
        }

        return output;

    }

    public static int[] sol2(int arr[]){
        int n = arr.length;
        int output[] = new int[n];

        Stack<Integer>st = new Stack<>();
        for(int i = 0; i<n; i++){

            while(!st.isEmpty() && arr[st.peek()]>arr[i]){
                st.pop();
            }

            if(st.isEmpty()){
                output[i] = -1;
            }
            else output[i] = st.peek();

            st.push(i);
        }

        return output;
    }
    public int sumSubarrayMins(int[] arr) {
        
        long total = 0;
        int right[] = sol1(arr);
        int left[] = sol2(arr);
        int mod = 1000000007;

        for(int i = 0; i<arr.length; i++){
                int req1 = right[i]-i;
                int req2 = i-left[i];

                long contrib = (req1 * req2) % mod;
            contrib = (contrib * arr[i]) % mod;

            total = (total + contrib) % mod;
            
        }

        return (int)total;
    }
}