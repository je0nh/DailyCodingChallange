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
        ListNode list1 = new ListNode(0);
        ListNode dummy1 = list1;
        ListNode list2 = new ListNode(0);
        ListNode dummy2 = list2;

        while (head != null) {
            int val = head.val;
            if (val < x) {
                dummy1.next = new ListNode(val);
                dummy1 = dummy1.next;
            } else {
                dummy2.next = new ListNode(val);
                dummy2 = dummy2.next;
            }
            head = head.next;
        }
        dummy1.next = list2.next;
        return list1.next;
    }
}