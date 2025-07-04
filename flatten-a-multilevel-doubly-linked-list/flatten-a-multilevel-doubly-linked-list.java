// LeetCode: Flatten a Multilevel Doubly Linked List (flatten-a-multilevel-doubly-linked-list)
// Submission ID: 1686638694
// Language: java
// Timestamp (UTC): 2025-07-04T23:04:56Z

/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        if(head ==null)return head;
        
        Stack<Node>st = new Stack<>();
        
        st.add(head);
        
        Node dummy = new Node();
        Node tail = dummy;
        
        while(!st.isEmpty()){
            
            Node rem = st.pop();
            
            while(rem!=null){
                
                if(rem.child!=null){
                    if(rem.next!=null)st.add(rem.next);
                    tail.next = rem;
                    rem.prev = tail;
                    Node bacha = rem.child;
                    rem.child = null;
                    rem = bacha;
                    tail =tail.next;
                }
                else{
                    
                    tail.next = rem;
                    rem.prev = tail;
                    tail = tail.next;
                     rem = rem.next;
                }
                
               
            }
            
           
        }
        
          Node output = dummy.next;
        output.prev = null;
        return output;
    }
}