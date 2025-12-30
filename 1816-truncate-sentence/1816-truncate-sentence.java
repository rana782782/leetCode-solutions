class Solution {
    public String truncateSentence(String s, int k) {
        StringBuilder output = new StringBuilder();

        String arr[] = s.split(" ");

        for(int i = 0; i<k; i++){
            if(i!=k-1){
                output.append(arr[i]+" ");
            }
            else{
                output.append(arr[i]);
            }
        }

        return output.toString();
    }
}