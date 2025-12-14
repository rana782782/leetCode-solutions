class Solution {

    public static int countVow(String str){
        int count = 0;
        for(char ch : str.toCharArray()){
            if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u') count++;
        }
        return count;
    }

    public static String revStr(String str){
        return new StringBuilder(str).reverse().toString();
    }

    public String reverseWords(String s) {
        String[] arr = s.split(" ");
        StringBuilder output = new StringBuilder();

        int firstVow = countVow(arr[0]);
        output.append(arr[0]);

        for(int i = 1; i < arr.length; i++){
            output.append(" ");
            if(countVow(arr[i]) == firstVow){
                output.append(revStr(arr[i]));
            } else {
                output.append(arr[i]);
            }
        }

        return output.toString();
    }
}
