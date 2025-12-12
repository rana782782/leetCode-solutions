class Solution {
    public static int pivotIdx(int arr[]){
        int n = arr.length;
        for(int i = n-2; i>=0; i--){
            if(arr[i] < arr[i+1]) return i;
        }
        return -1;
    }

    public static void greaterNum(int arr[], int idx){
        int pivot = idx - 1;
        for(int i = arr.length - 1; i >= idx; i--){
            if(arr[i] > arr[pivot]){
                int t = arr[i];
                arr[i] = arr[pivot];
                arr[pivot] = t;
                break;
            }
        }
    }

    public static void rev(int arr[], int idx){
        int l = idx, r = arr.length - 1;
        while(l < r){
            int t = arr[l];
            arr[l] = arr[r];
            arr[r] = t;
            l++;
            r--;
        }
    }

    public int nextGreaterElement(int n) {
        String s = Integer.toString(n);
        int arr[] = new int[s.length()];
        for(int i = 0; i < s.length(); i++) arr[i] = s.charAt(i) - '0';

        int pIdx = pivotIdx(arr);
        if(pIdx == -1) return -1;

        greaterNum(arr, pIdx + 1);
        rev(arr, pIdx + 1);

        long ans = 0;
        for(int d : arr) ans = ans * 10 + d;
        if(ans > Integer.MAX_VALUE) return -1;

        return (int) ans;
    }
}
