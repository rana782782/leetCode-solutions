class Solution {
    public static class Pair{
        char ch;
        int time;

        Pair(char ch, int time){
            this.ch = ch;
            this.time = time;
        }
    }
    public int minCost(String colors, int[] neededTime) {
        Stack<Pair>st = new Stack<>();
            int output = 0;
            st.push(new Pair(colors.charAt(0),neededTime[0]));
        int i = 1;
    while(i<colors.length()){
            char ch = colors.charAt(i);
            if(!st.isEmpty() && st.peek().ch == ch){
                  if(st.peek().time<=neededTime[i]){
                    Pair rem = st.pop();
                    output+=rem.time;
                    st.push(new Pair(ch,neededTime[i]));
                  }
                  else{
                    output+=neededTime[i];
                  }
        }
        else{
            st.push(new Pair(ch,neededTime[i]));
        }
        i++;
    }

    return output;
            
    }
}