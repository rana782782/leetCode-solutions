// LeetCode: Occurrences After Bigram (occurrences-after-bigram)
// Submission ID: 1781164886
// Language: java
// Timestamp (UTC): 2025-09-24T11:05:57Z

class Solution {
    public String[] findOcurrences(String text, String first, String second) {
        String arr[] = text.split(" ");
        int n = arr.length;
        List<String>ans = new ArrayList<>();
        for(int i = 0; i<arr.length; i++){
            if(arr[i].equals(first)){
                if(i+1<n && arr[i+1].equals(second)){
                    if(i+2<n)ans.add(arr[i+2]);
                }
            }
        }

        String output[] = new String[ans.size()];
        int idx = 0;

        for(String str : ans){
            output[idx++] = str;
        }

        return output;
    }
}