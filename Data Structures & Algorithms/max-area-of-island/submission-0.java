class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 0){
                    continue;
                }
                max = Math.max(max, area(grid, i, j));

            }
        }
        return max;
        
    }

    public int area(int[][] grid, int x, int y){
        if(x > grid.length - 1 || x < 0 || y < 0 || y > grid[0].length -1 || grid[x][y] == 0){
            return 0;
        }
        
        grid[x][y] = 0;
        return 1 + area(grid, x + 1, y) + area(grid, x - 1, y) + area(grid, x, y + 1) + area(grid, x, y - 1);
    }
}
