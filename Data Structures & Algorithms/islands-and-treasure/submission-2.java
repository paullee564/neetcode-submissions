class Solution {
    public void islandsAndTreasure(int[][] grid) {
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                int c = grid[i][j];
                if(c == -1){
                    continue;
                }
                else if(c == 0){
                    bfs(grid, i + 1, j, 1);
                    bfs(grid, i - 1, j, 1);
                    bfs(grid, i, j + 1, 1);
                    bfs(grid, i, j - 1, 1);
                }
            }
        }
    }

    public void bfs(int[][] grid, int x, int y, int distance){
        if(x > grid.length - 1 || x < 0 || y < 0 || y > grid[0].length - 1 || grid[x][y] == -1 || grid[x][y] <= distance){
            return;
        }
        grid[x][y] = Math.min(grid[x][y], distance);
        bfs(grid, x + 1, y, distance + 1);
        bfs(grid, x - 1, y, distance + 1);
        bfs(grid, x, y + 1, distance + 1);
        bfs(grid, x, y - 1, distance + 1);
        return;

        
    }
}
