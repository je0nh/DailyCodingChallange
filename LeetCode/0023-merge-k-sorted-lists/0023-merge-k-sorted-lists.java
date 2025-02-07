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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null) return new ListNode();

        Queue<ListNode> q = new LinkedList<>();
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                q.add(lists[i]);
            }
        }

        ListNode a = q.poll();
        while (!q.isEmpty()) {
            ListNode b = q.poll();
            if (b ==  null) break;

            a = merge(a, b);
        }
        return a;
    }

    private ListNode merge(ListNode n1, ListNode n2) {
        ListNode ans = new ListNode(0);
        ListNode dummy = ans;

        while (n1 != null && n2 != null) {
            if (n1.val < n2.val) {
                dummy.next = new ListNode(n1.val);
                n1 = n1.next;
            } else {
                dummy.next = new ListNode(n2.val);
                n2 = n2.next;
            }
            dummy = dummy.next;
        }

        dummy.next = n1 != null ? n1 : n2;

        return ans.next;
    }
}