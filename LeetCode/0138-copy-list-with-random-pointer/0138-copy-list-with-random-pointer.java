/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();

        Node shallowCopyHead = head;
        while (shallowCopyHead != null) {
            map.put(shallowCopyHead, new Node(shallowCopyHead.val));
            shallowCopyHead = shallowCopyHead.next;
        }

        shallowCopyHead = head;
        while (shallowCopyHead != null) {
            Node deepCopyHead = map.get(shallowCopyHead);
            deepCopyHead.next = map.get(shallowCopyHead.next);
            deepCopyHead.random = map.get(shallowCopyHead.random);
            shallowCopyHead = shallowCopyHead.next;
        }
        return map.get(head);
    }
}