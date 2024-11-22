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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode answer = new ListNode(0);
        ListNode current = answer;

        ArrayList<ListNode> array = new ArrayList<>();
        while (head != null) {
            array.add(head);
            head = head.next;
            if (array.size() == k) {
                while (array.size() > 0) {
                    int n = array.size() - 1;
                    current.next = array.get(n);
                    current = current.next;
                    array.remove(n);
                }
            }
        }

        if (array.size() > 0) {
            for (ListNode node : array) {
                current.next = node;
                current = current.next;
            }
        }

        current.next = null;

        return answer.next;
    }
}