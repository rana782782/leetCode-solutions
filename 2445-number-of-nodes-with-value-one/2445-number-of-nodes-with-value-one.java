class Solution {
static int N;
public static boolean solution(int arr[],int i){
    int ans = 0;
        while(i!=0){
                ans+=arr[i];
                i =i/2;;
        }

        return ans%2!=0;
}
 
    public int numberOfNodes(int n, int[] queries) {
        N = n;
        int arr[] = new int[n+1];

        for(int q : queries){

            arr[q]++;
        }

        int output = 0;

        for(int i = 1; i<=n; i++){
              if(solution(arr,i))output++;
        }

        return output;
    }
}