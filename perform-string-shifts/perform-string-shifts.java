// LeetCode: Perform String Shifts (perform-string-shifts)
// Submission ID: 1642952909
// Language: java
// Timestamp (UTC): 2025-05-24T11:34:05Z

class Solution {
    public String stringShift(String s, int[][] shift) {
        Deque<Character>q = new ArrayDeque<>();
        StringBuilder output = new StringBuilder();

        char arr[] = s.toCharArray();

        for(char ch : arr){
            q.add(ch);
        }

        for(int in[] : shift){
                int dir = in[0];
                 int steps = in[1];

                 if(dir == 0){
                    for(int i = 1; i<=steps; i++){
                        char ch = q.removeFirst();
                        q.addLast(ch);
                    }
                 }
                 else{
                    for(int i = 1; i<=steps; i++){
                        char ch = q.removeLast();
                        q.addFirst(ch);
                    }
                 }
        }

        while(q.size()!=0){
            output.append(q.poll());
        }

        return output.toString();
    }
}