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
        int currentVal = l1.val + l2.val;
        ListNode answer = new ListNode(currentVal % 10);
        int roundUp = currentVal / 10;

        ListNode l1NextNode = l1.next;
        ListNode l2NextNode = l2.next;
        ListNode ansNext = answer;
        while (l1NextNode != null || l2NextNode != null || roundUp != 0) {
            int l1val = (l1NextNode != null) ? l1NextNode.val : 0;
            int l2val = (l2NextNode != null) ? l2NextNode.val : 0;

            int sum = l1val + l2val + roundUp;
            roundUp = sum / 10;
            ansNext.next = new ListNode(sum % 10);
            ansNext = ansNext.next;
            // System.out.println(sum % 10);

            l1NextNode = (l1NextNode != null) ? l1NextNode.next : null;
            l2NextNode = (l2NextNode != null) ? l2NextNode.next : null;
        }

        // int l1Value = l1.val;
        // System.out.println(l1Value);

        return answer;
    }
}