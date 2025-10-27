class Solution {
    public static int laser(String str){
        int output = 0;
        for(char ch : str.toCharArray()){
            if(ch == '1')output++;
        }

        return output;
    }
    public int numberOfBeams(String[] bank) {
        int n = bank.length;
        List<Integer>list = new ArrayList<>();
        int idx = 0;
        for(String str : bank){
            int ans = laser(str);
            System.out.print(ans+" ");
            if(ans!=0)list.add(ans);
        }

        int output = 0;
        for(int i = 0; i<list.size()-1; i++){
            int ans = list.get(i)*list.get(i+1);
            output+=ans;
        }
      

    return output;
}
}