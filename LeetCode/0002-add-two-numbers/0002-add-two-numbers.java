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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode();
        ListNode dummy = ans;
        int carry = 0;

        while (l1 != null || l2 != null) {
            int num1 = (l1 != null) ? l1.val : 0;
            int num2 = (l2 != null) ? l2.val : 0;
            int sum = num1 + num2 + carry;

            carry = sum / 10;
            ListNode tmp = new ListNode();
            tmp.val = sum % 10;

            dummy.next = tmp;
            dummy = dummy.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        if (carry != 0) dummy.next = new ListNode(carry);
        if (l1 != null) dummy.next = l1;
        if (l2 != null) dummy.next = l2;
        return ans.next;
    }
}