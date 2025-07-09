// LeetCode: Delete N Nodes After M Nodes of a Linked List (delete-n-nodes-after-m-nodes-of-a-linked-list)
// Submission ID: 1691397484
// Language: java
// Timestamp (UTC): 2025-07-09T01:22:10Z

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteNodes(ListNode head, int m, int n) {
        ListNode temp = head;
        
        int preserve = m;
        int remove = n;
        
        while(temp!=null){
            
            while(temp!=null && preserve-->1){
                temp = temp.next;
                
            }
            
            preserve = m;
            ListNode ref1 = temp;
           if(temp!=null)temp = temp.next;
            
            
            while(temp!=null && remove-->0){
                temp  = temp.next;
            }
            remove = n;
           if(ref1!=null) ref1.next = temp;
            
        }
        
        
        return head;
    }
}