class Solution {
    public static int pivotIdx(int arr[]){
        int idx = -1;
        int n = arr.length;

        for(int i = n-2; i>=0; i--){
            if(arr[i]<arr[i+1]){
                idx = i;
                break;
            }
        }

        return idx;
    }

 public static void greaterNum(int arr[], int idx){
    int pivot = idx - 1;

    for(int i = arr.length - 1; i >= idx; i--){
        if(arr[i] > arr[pivot]){
            int temp = arr[i];
            arr[i] = arr[pivot];
            arr[pivot] = temp;
            break;
        }
    }
}


    public static void rev(int arr[],int idx){
            int l = idx;
            int right = arr.length-1;

            while(l<right){
                int temp = arr[right];
                arr[right] = arr[l];
                arr[l] = temp;
                l++;
                right--;
            }
    }
    public void nextPermutation(int[] nums) {
        int pIdx = pivotIdx(nums);
        if(pIdx == -1){
            Arrays.sort(nums);
            return;
        }

        greaterNum(nums, pIdx+1);
        rev(nums,pIdx+1);
       
    }
}