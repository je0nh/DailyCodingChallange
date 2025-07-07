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
        ListNode ans = new ListNode(0);
        ListNode dummy = ans;

        while (list1 != null && list2 != null) {
            int val1 = list1.val;
            int val2 = list2.val;

            if (val1 < val2) {
                dummy.next = new ListNode(val1);
                list1 = list1.next;
            } else {
                dummy.next = new ListNode(val2);
                list2 = list2.next;
            }
            dummy = dummy.next;
        }

        if (list1 != null) dummy.next = list1;
        if (list2 != null) dummy.next = list2;
        return ans.next;
    }
}