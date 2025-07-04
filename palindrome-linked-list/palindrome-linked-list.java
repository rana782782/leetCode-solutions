// LeetCode: Palindrome Linked List (palindrome-linked-list)
// Submission ID: 1686617288
// Language: java
// Timestamp (UTC): 2025-07-04T22:05:08Z

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
    public boolean isPalindrome(ListNode head) {
       if(head.next == null)return true;
        
        if(head.next.next == null){
            return head.val == head.next.val;
        }
        
        
        List<ListNode>arr = new ArrayList<>();
        ListNode temp = head;
        
        while(temp!=null){
            arr.add(temp);
            temp = temp.next;
        }
        
        int start = 0;
         int end = arr.size()-1;
        
        while(start<end){
            if(arr.get(start).val!=arr.get(end).val)return false;
            start++;
            end--;
        }
        
        return true;
        
        
        
    }
}