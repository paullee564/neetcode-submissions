
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Node> graph = new HashMap<>();

        // Build graph
        for (int[] prereq : prerequisites) {
            int course = prereq[0];
            int prerequisite = prereq[1];

            graph.putIfAbsent(course, new Node());
            graph.putIfAbsent(prerequisite, new Node());

            graph.get(course).neighbors.add(graph.get(prerequisite));
        }

        Set<Node> visiting = new HashSet<>();
        Set<Node> safe = new HashSet<>();

        // Check every connected component
        for (Node node : graph.values()) {
            if (!dfs(node, visiting, safe)) {
                return false;
            }
        }

        return true;
    }

    private boolean dfs(Node node, Set<Node> visiting, Set<Node> safe) {
        // Cycle detected
        if (visiting.contains(node)) {
            return false;
        }

        // Already verified as cycle-free
        if (safe.contains(node)) {
            return true;
        }

        visiting.add(node);

        for (Node neighbor : node.neighbors) {
            if (!dfs(neighbor, visiting, safe)) {
                return false;
            }
        }

        visiting.remove(node);
        safe.add(node);

        return true;
    }
}

class Node {
    List<Node> neighbors = new ArrayList<>();
}