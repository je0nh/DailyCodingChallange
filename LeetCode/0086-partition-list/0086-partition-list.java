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
    public ListNode partition(ListNode head, int x) {
        ListNode down = new ListNode(0);
        ListNode up = new ListNode(0);

        ListNode downDummy = down;
        ListNode upDummy = up;
        while (head != null) {
            int n = head.val;
            if (n >= x) {
                upDummy.next = new ListNode(n);
                upDummy = upDummy.next;
            } else {
                downDummy.next = new ListNode(n);
                downDummy = downDummy.next;
            }
            head = head.next;
        }

        downDummy.next = up.next;
        return down.next;
    }
}