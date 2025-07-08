// LeetCode: Reverse Nodes in k-Group (reverse-nodes-in-k-group)
// Submission ID: 1691336705
// Language: java
// Timestamp (UTC): 2025-07-08T22:45:38Z

class Solution {
    public static class Pair {
        ListNode first, last;
        Pair(ListNode first, ListNode last) {
            this.first = first;
            this.last = last;
        }
    }

    public static Pair getNode(int firstIdx, int lastIdx, ArrayList<ListNode> list) {
        ListNode ref = list.get(lastIdx);
        for (int i = lastIdx; i > firstIdx; i--) {
            list.get(i).next = list.get(i - 1);
        }
        return new Pair(ref, list.get(firstIdx));
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ArrayList<ListNode> list = new ArrayList<>();
        ListNode temp = head;

        while (temp != null) {
            ListNode next = temp.next;
            temp.next = null;
            list.add(temp);
            temp = next;
        }

        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;

        int i = 0;
        while (i + k <= list.size()) {
            Pair p = getNode(i, i + k - 1, list);
            tail.next = p.first;
            tail = p.last;
            i += k;
        }

        // Attach remaining nodes if any
        while (i < list.size()) {
            tail.next = list.get(i);
            tail = tail.next;
            i++;
        }

        return dummy.next;
    }
}
