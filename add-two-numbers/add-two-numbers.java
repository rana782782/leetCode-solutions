// LeetCode: Add Two Numbers (add-two-numbers)
// Submission ID: 1652092667
// Language: java
// Timestamp (UTC): 2025-06-02T20:29:10Z

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
    public static ListNode reverse(ListNode root){
        ListNode head = null;
        ListNode temp = root;

        while(temp!=null){
            ListNode currNode = new ListNode(temp.val);

            if(head == null)head = currNode;
            else{
                currNode.next = head;
                head = currNode;
            }
            temp = temp.next;
        }

        return head;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode t1 = reverse(l1);
        ListNode t2 = reverse(l2);

        Stack<Integer>st1 = new Stack<>();
        Stack<Integer>st2 = new Stack<>();

        while(t1!=null){
            st1.push(t1.val);
            t1 = t1.next;
        }

        while(t2!=null){
            st2.push(t2.val);
            t2 = t2.next;
        }

        int carry = 0;
        ListNode head= null;
        
        while(!st1.isEmpty() || !st2.isEmpty() || carry!=0){

            int sum = carry;

            if(!st1.isEmpty()){
                sum+=st1.pop();
            }

            if(!st2.isEmpty()){
                sum+=st2.pop();
            }

            carry = sum/10;
            ListNode currNode = new ListNode(sum%10);
            if(head == null)head = currNode;
            else{
                currNode.next = head;
                head = currNode;
            }
            
        }

        return reverse(head);
    }
}