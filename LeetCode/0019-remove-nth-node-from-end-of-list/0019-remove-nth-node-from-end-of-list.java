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
        if (head.next == null) return null;

        Map<Integer, ListNode> map = new HashMap<>();
        int idx = 0;
        while (head != null) {
            map.put(idx, new ListNode(head.val));
            // {0: node(1), 1: node(2) .. }
            head = head.next;
            idx++;
        }

        int remove = idx - n;
        ListNode ans = new ListNode(0);
        ListNode dummy = ans;
        for (int i = 0; i < idx; i++) {
            if (i == remove) continue;

            dummy.next = map.get(i);
            dummy = dummy.next;
        }
        return ans.next;
    }
}