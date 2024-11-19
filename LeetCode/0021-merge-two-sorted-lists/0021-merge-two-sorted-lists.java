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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode answer = new ListNode(0);
        ListNode current = answer;

        while (list1 != null || list2 != null) {
            int val1 = (list1 != null) ? list1.val : Integer.MAX_VALUE;
            int val2 = (list2 != null) ? list2.val : Integer.MAX_VALUE;

            if (val1 < val2) {
                current.next = new ListNode(val1);
                list1 = list1.next;
            } else {
                current.next = new ListNode(val2);
                list2 = list2.next;
            }

            current = current.next;
        }
        return answer.next;
    }
}