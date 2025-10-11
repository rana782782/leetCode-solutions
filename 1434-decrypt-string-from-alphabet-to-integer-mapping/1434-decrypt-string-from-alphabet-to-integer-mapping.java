class Solution {
    public String freqAlphabets(String s) {
        char arr[] = s.toCharArray();

        StringBuilder output = new StringBuilder();
         
        for(int i = arr.length-1; i>=0; i--){
             char ch = arr[i];
             if(ch == '#'){
                
          int num = Integer.parseInt(s.substring(i - 2, i));
                output.append((char) ('a' + num - 1));
                  i-=2;
                 continue;
             }
             else{
                 int num = s.charAt(i) - '0';
                output.append((char) ('a' + num - 1));
             }
        }

        return output.reverse().toString();

    }
}