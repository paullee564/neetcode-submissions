class Solution {
    public boolean validTree(int n, int[][] edges) {
        // A tree must have exactly n - 1 edges.
        if (edges.length != n - 1) {
            return false;
        }

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        Set<Integer> visited = new HashSet<>();

        dfs(0, graph, visited);

        return visited.size() == n;
    }

    private void dfs(int node, List<List<Integer>> graph,
                     Set<Integer> visited) {
        if (visited.contains(node)) {
            return;
        }

        visited.add(node);

        for (int neighbor : graph.get(node)) {
            dfs(neighbor, graph, visited);
        }
    }
}