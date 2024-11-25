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
        ListNode answer = new ListNode(0);
        ListNode prev = answer;
        ListNode current = head;
        while (current != null) {
            if (current.next != null && current.val == current.next.val) {
                int currentVal = current.val;
                while (current != null && currentVal == current.val) {
                    current = current.next;
                }
            } else {
                prev.next = current;
                prev = prev.next;
                current = current.next;
            }
        }

        prev.next = null;

        return answer.next;
    }
}