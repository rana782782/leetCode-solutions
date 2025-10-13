class Solution {
    public List<String> printVertically(String s) {
        int maxLen = 0;

        String arr[] = s.split(" ");

        for(String str : arr){
                    maxLen = Math.max(maxLen,str.length());
        }

        List<String>output = new ArrayList<>();

        int idx = 0;
        while(idx<maxLen){
            StringBuilder subAns = new StringBuilder();

            for(String str : arr){
                if(idx>=str.length()){
                   subAns.append(" ");
                }
                else{
                    subAns.append(str.charAt(idx));
                }
            }
            String temp = subAns.toString();
            output.add(temp.replaceAll("\\s+$", ""));
            idx++;
        }

        return output;
    }
}