// LeetCode: Remove Nth Node From End of List (remove-nth-node-from-end-of-list)
// Submission ID: 1690047227
// Language: java
// Timestamp (UTC): 2025-07-07T20:28:29Z

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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = 0;
        
        ListNode temp = head;
        
        while(temp!=null){
            length++;
            temp = temp.next;
        }
        
        
        int pos = length-n;
        
        int currPos = 1;
        
        if(pos == 0)return head.next;
        
        ListNode back = head;
        ListNode front = head.next;
        
        while(currPos!=pos){
            back = back.next;
            front = front.next;
            currPos++;
        }
        
        back.next = front.next;
        return head;
        
    }
}