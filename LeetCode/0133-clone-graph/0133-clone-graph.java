/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    private HashMap<Node, Node> visited = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) return null;

        Node clone = new Node();
        clone.val = node.val;
        visited.put(node, clone);

        dfs(clone, node);
        return clone;
    }

    private void dfs(Node clone, Node node) {
        ArrayList<Node> neigh = new ArrayList<>();
        for (Node n : node.neighbors) {
            if (visited.containsKey(n)) {
                // 만약 이미 노드에 방문하게 되면 dfs를 호출하지 않기 때문에 재귀에서 빠져나올 수 있음
                neigh.add(visited.get(n));
            } else {
                Node cloneNeigh = new Node();
                cloneNeigh.val = n.val;
                visited.put(n, cloneNeigh);

                neigh.add(cloneNeigh);
                dfs(cloneNeigh, n);
            }
        }
        clone.neighbors = neigh;
    }
}