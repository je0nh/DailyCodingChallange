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
        Node current = head;
        HashMap<Node, Node> map = new HashMap<>();
        
        // System.out.println(head.next.random.val);

        while (current != null) {
            map.put(current, new Node(current.val));
            current = current.next;
        }

        current = head;
        while (current != null) {
            map.get(current).next = map.get(current.next);
            map.get(current).random = map.get(current.random);
            current = current.next;
        }

        return map.get(head);
    }
}