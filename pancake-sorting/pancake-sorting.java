// LeetCode: Pancake Sorting (pancake-sorting)
// Submission ID: 1774944004
// Language: java
// Timestamp (UTC): 2025-09-18T12:16:35Z

import java.util.*;

class Solution {
    public static void flip(int arr[], int idx){
       
        for(int i = 0; i <= idx/2; i++){
            int temp = arr[i];
            arr[i] = arr[idx - i];
            arr[idx - i] = temp;
        }
    }

    public static class Pair{
        int idx, num;
        Pair(int idx, int num){
            this.idx = idx;
            this.num = num;
        }
    }

    public static Pair findMax(int arr[], int lastIdx){
        Pair ans = new Pair(-1, Integer.MIN_VALUE);
        for(int i = 0; i <= lastIdx; i++){
            if(arr[i] > ans.num){
                ans.num = arr[i];
                ans.idx = i;
            }
        }
        return ans;
    }

    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> output = new ArrayList<>();
        int j = arr.length - 1;

        while(j > 0){
            if(arr[j] == j + 1){ 
                j--;
                continue;
            }
            Pair p = findMax(arr, j);
            if(p.idx != 0){
                output.add(p.idx + 1);
                flip(arr, p.idx);
            }
           
            output.add(j + 1);
            flip(arr, j);

            j--;
        }
        return output;
    }
}
