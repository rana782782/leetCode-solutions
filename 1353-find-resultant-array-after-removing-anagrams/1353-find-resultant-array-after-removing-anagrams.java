class Solution {
    public List<String> removeAnagrams(String[] words) {
        int n = words.length;

        String codes[] = new String[n];
        int idx = 0;

        for(String str : words){
            int arr[] = new int[26];

            for(char ch : str.toCharArray()){
                arr[ch-'a']++;
            }

            String code = Arrays.toString(arr);
            codes[idx++] = code;
        }

        List<String>output = new ArrayList<>();

        output.add(words[0]);

        for(int i = 1; i<n; i++){
            if(!codes[i-1].equals(codes[i]))output.add(words[i]);
        }

        return output;
    }
}