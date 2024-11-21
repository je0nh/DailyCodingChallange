class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode answer = new ListNode(0);
        answer.next = head;
        ListNode prev = answer;

        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
        }

        Stack<ListNode> stack = new Stack<>();
        ListNode current = prev.next;
        for (int i = 0; i <= right - left; i++) {
            stack.add(current);
            current = current.next;
        }

        while (!stack.isEmpty()) {
            prev.next = stack.pop();
            prev = prev.next;
        }

        prev.next = current;

        return answer.next;
    }
}