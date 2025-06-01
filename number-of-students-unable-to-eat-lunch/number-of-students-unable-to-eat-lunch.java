// LeetCode: Number of Students Unable to Eat Lunch (number-of-students-unable-to-eat-lunch)
// Submission ID: 1651051533
// Language: java
// Timestamp (UTC): 2025-06-01T19:52:45Z

class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        
        Deque<Integer>dq = new ArrayDeque<>();
        
        for(int ele : students){
            dq.add(ele);
        }
        
        
        
        int idx = 0;
        int count = 0;
        
        while(!dq.isEmpty()){
            if(dq.peek() == sandwiches[idx]){
                dq.poll();
                idx++;
                count = 0;
            }
            else{
                
                int ele = dq.poll();
                dq.addLast(ele);
                count++;
            }
            
            if(count == dq.size())break;
        }
        
        return dq.size();
    }
}