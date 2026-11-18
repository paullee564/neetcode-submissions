class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer, Node> graph = new HashMap<>();

        // Create every course, including those with no prerequisites
        for (int i = 0; i < numCourses; i++) {
            graph.put(i, new Node(i));
        }

        // Course -> its prerequisites
        for (int[] prereq : prerequisites) {
            int course = prereq[0];
            int req = prereq[1];

            graph.get(course).neighbors.add(graph.get(req));
        }

        HashSet<Node> seen = new HashSet<>();
        HashSet<Node> safe = new HashSet<>();
        List<Integer> order = new ArrayList<>();

        // Check every course, including disconnected components
        for (Node n : graph.values()) {
            if (dfs(n, seen, safe, order)) {
                return new int[]{};
            }
        }

        // Convert the ordering into an array
        int[] ans = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            ans[i] = order.get(i);
        }

        return ans;
    }

    // Returns true if a cycle is found
    public boolean dfs(Node n, HashSet<Node> seen,
                       HashSet<Node> safe, List<Integer> order) {

        if (safe.contains(n)) return false;
        if (seen.contains(n)) return true;

        seen.add(n);

        for (Node pre : n.neighbors) {
            if (dfs(pre, seen, safe, order)) {
                return true;
            }
        }

        seen.remove(n);
        safe.add(n);

        // All prerequisites have been processed
        order.add(n.val);

        return false;
    }
}

class Node {
    int val;
    List<Node> neighbors;

    public Node(int val) {
        this.val = val;
        this.neighbors = new ArrayList<>();
    }
}
