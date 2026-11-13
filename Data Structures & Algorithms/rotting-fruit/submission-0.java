class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> que = new ArrayDeque<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    que.offer(new int[]{i, j, 0});
                }
            }
        }

        int[][] directions = {
            {1, 0}, {-1, 0}, {0, 1}, {0, -1}
        };

        int time = 0;

        while (!que.isEmpty()) {
            int[] cell = que.poll();

            int r = cell[0];
            int c = cell[1];
            int currentTime = cell[2];

            time = Math.max(time, currentTime);

            for (int[] dir : directions) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                if (nr < 0 || nr >= grid.length ||
                    nc < 0 || nc >= grid[0].length ||
                    grid[nr][nc] != 1) {
                    continue;
                }

                grid[nr][nc] = 2;
                que.offer(new int[]{nr, nc, currentTime + 1});
            }
        }

        for (int[] row : grid) {
            for (int orange : row) {
                if (orange == 1) {
                    return -1;
                }
            }
        }

        return time;
    }
}