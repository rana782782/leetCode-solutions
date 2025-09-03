// LeetCode: Linked List Components (linked-list-components)
// Submission ID: 1757946412
// Language: java
// Timestamp (UTC): 2025-09-03T07:28:08Z

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

    public static void dfs(ListNode temp,HashSet<Integer>set){
        while(temp!=null && set.contains(temp.val)){
            set.remove(temp.val);
            temp = temp.next;
        }
    }
    public int numComponents(ListNode head, int[] nums) {
        HashSet<Integer>set = new HashSet<>();
        for(int ele : nums){
            set.add(ele);
        }

        ListNode temp = head;
       
        int count = 0;

        while(temp!=null){
           if(set.contains(temp.val)){
               dfs(temp,set);
               count++;
           }
            temp = temp.next;
        }
  
        
            
        System.out.println(count);
        return count;
    }
}