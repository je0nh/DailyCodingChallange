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
    public ListNode sortList(ListNode head) {
        if (head == null) return null;

        List<Integer> sort = new ArrayList<>();
        while (head != null) {
            sort.add(head.val);
            head = head.next;
        }

        Collections.sort(sort);
        ListNode ans = new ListNode();
        ListNode current = ans;
        for (int i : sort) {
            current.next = new ListNode(i);
            current = current.next;
        }

        return ans.next;
    }
}