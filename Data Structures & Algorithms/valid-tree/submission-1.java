class Solution {
    public boolean validTree(int n, int[][] edges) {
        HashMap<Integer, Node> graph = new HashMap<>();

        for(int i = 0; i < n; i++){
            graph.put(i, new Node(i, new ArrayList<>()));
        }

        for(int[] edge: edges){
            int node1 = edge[0];
            int node2 = edge[1];
            graph.get(node1).neighbors.add(graph.get(node2));
            graph.get(node2).neighbors.add(graph.get(node1));
        }

        HashSet<Node> seen = new HashSet<>();
        HashSet<Node> safe = new HashSet<>();
        Node cur = graph.get(0);

        if(isCycle(cur, seen, safe) || safe.size() != n){
            return false;
        }
        return true;

    }

    public boolean isCycle(Node n, Set<Node> seen, Set<Node> safe){
        if(seen.contains(n)){
            return true;
        }
        if(safe.contains(n)){
            return false;
        }
        seen.add(n);
        for(Node neighbor: n.neighbors){
            neighbor.neighbors.remove(n);
            if(isCycle(neighbor, seen, safe)){
                return true;
            }
        }
        seen.remove(n);
        safe.add(n);
        return false;
    }
}

class Node{
    int val;
    List<Node> neighbors;

    public Node(int val, List<Node> neighbors){
        this.val = val;
        this.neighbors = neighbors;
    }
}
