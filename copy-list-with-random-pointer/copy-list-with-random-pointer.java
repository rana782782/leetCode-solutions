// LeetCode: Copy List with Random Pointer (copy-list-with-random-pointer)
// Submission ID: 1725397566
// Language: java
// Timestamp (UTC): 2025-08-06T08:29:08Z

/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null)return null;
        HashMap<Node,Node>map = new HashMap<>();

        Node temp = head;

        while(temp!=null){
            map.put(temp,new Node(temp.val));
            temp = temp.next;
        }


        temp = head;

        while(temp!=null){
            Node cloned = map.get(temp);
            cloned.next = map.get(temp.next);
            cloned.random = map.get(temp.random);
            temp = temp.next;
        }

        return map.get(head);
    }
}