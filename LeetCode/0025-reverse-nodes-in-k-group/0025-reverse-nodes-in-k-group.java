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
        List<Stack<ListNode>> list = new ArrayList<>();

        ListNode copyHead = head;
        Stack<ListNode> stack = new Stack<>();
        while (copyHead != null) {
            ListNode node = new ListNode(copyHead.val);
            stack.add(node);

            if (stack.size() % k == 0) {
                list.add(stack);
                stack = new Stack<>();
            }
            copyHead = copyHead.next;
        }

        ListNode ans = new ListNode(0);
        ListNode dummy = ans;
        for (int i = 0; i < list.size(); i++) {
            Stack<ListNode> tmp = list.get(i);

            while (tmp.size() > 0) {
                dummy.next = tmp.pop();
                dummy = dummy.next;
                head = head.next;
            }
        }
        dummy.next = head;
        return ans.next;
    }
}