class Solution {
    private int[][] directions = {
        {1, 0}, {-1, 0}, {0, 1}, {0, -1}
    };

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;

        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];

        // Start from Pacific: top and left edges
        for (int r = 0; r < rows; r++) {
            dfs(heights, r, 0, pacific);
        }

        for (int c = 0; c < cols; c++) {
            dfs(heights, 0, c, pacific);
        }

        // Start from Atlantic: bottom and right edges
        for (int r = 0; r < rows; r++) {
            dfs(heights, r, cols - 1, atlantic);
        }

        for (int c = 0; c < cols; c++) {
            dfs(heights, rows - 1, c, atlantic);
        }

        // Find cells reachable from both oceans
        List<List<Integer>> result = new ArrayList<>();

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (pacific[r][c] && atlantic[r][c]) {
                    result.add(Arrays.asList(r, c));
                }
            }
        }

        return result;
    }

    private void dfs(int[][] heights, int r, int c,
                     boolean[][] visited) {

        if (visited[r][c]) {
            return;
        }

        visited[r][c] = true;

        for (int[] dir : directions) {
            int nr = r + dir[0];
            int nc = c + dir[1];

            if (nr < 0 || nr >= heights.length ||
                nc < 0 || nc >= heights[0].length ||
                visited[nr][nc] ||
                heights[nr][nc] < heights[r][c]) {
                continue;
            }

            dfs(heights, nr, nc, visited);
        }
    }
}