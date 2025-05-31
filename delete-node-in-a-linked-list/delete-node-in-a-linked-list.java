// LeetCode: Delete Node in a Linked List (delete-node-in-a-linked-list)
// Submission ID: 1650001245
// Language: java
// Timestamp (UTC): 2025-05-31T18:26:35Z

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
	node.next = node.next.next;
    }
}