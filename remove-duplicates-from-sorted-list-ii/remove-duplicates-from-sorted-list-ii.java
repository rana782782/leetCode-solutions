// LeetCode: Remove Duplicates from Sorted List II (remove-duplicates-from-sorted-list-ii)
// Submission ID: 1653095050
// Language: java
// Timestamp (UTC): 2025-06-03T21:10:44Z

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
    public ListNode deleteDuplicates(ListNode head) {
        
        if(head == null || head.next == null)return head;
      TreeMap<Integer,Integer>map = new TreeMap<>();
        
        ListNode temp = head;
        
        while(temp!=null){
            map.put(temp.val,map.getOrDefault(temp.val,0)+1);
            temp = temp.next;
        }
        
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        
        for(int ele : map.keySet()){
            
            if(map.get(ele) == 1){
                ListNode currNode = new ListNode(ele);
            tail.next = currNode;
            tail = tail.next;
            }
            
        }
        
        return dummy.next;
    }
}