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
        ArrayList<ListNode> array = new ArrayList<>();
        while (head != null) {
            array.add(head);
            head = head.next;
        }

        ListNode answer = new ListNode(0);
        ListNode dummy = answer;
        for (int i = 0; i < array.size(); i++) {
            if (i == array.size() - n) continue;
            dummy.next = array.get(i);
            dummy = dummy.next;
        }

        dummy.next = null;

        return answer.next;
    }
}