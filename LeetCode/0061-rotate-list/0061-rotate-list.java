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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;

        ListNode cntDummy = head;
        int n = 0;
        while (cntDummy != null) {
            cntDummy = cntDummy.next;
            n++;
        }

        // while (n < k) {
        //     k -= n;
        // }

        // k %= n;

        int count = 0;
        while (count < k % n) {
            ListNode start = head;
            while (start.next != null) {
                start = start.next;
            }

            ListNode end = head;
            ListNode dummy = end;
            while (dummy.next.next != null) {
                dummy = dummy.next;
            }
            dummy.next = null;

            start.next = end;
            head = start;
            count++;
        }
        return head;
    }
}