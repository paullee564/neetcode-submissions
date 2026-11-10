class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return null;

        HashMap<Node, Node> map = new HashMap<>();
        return clone(node, map);
    }

    public Node clone(Node node, HashMap<Node, Node> map) {
        if (map.containsKey(node)) {
            return map.get(node);
        }

        Node copy = new Node(node.val);

        // Store BEFORE recursing
        map.put(node, copy);

        for (Node neighbor : node.neighbors) {
            copy.neighbors.add(clone(neighbor, map));
        }

        return copy;
    }
}