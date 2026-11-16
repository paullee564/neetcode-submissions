class Solution {
    public void solve(char[][] board) {
        ArrayList<int[]> ans = new ArrayList<>();
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if((i != 0 && i != board.length -1) && (j != 0 && j != board[0].length - 1)){
                    continue;
                }
                dfs(board, ans, visited, i, j);
            }
        }
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                board[i][j] = 'X';
            }
        }


        for(int[] coordinates: ans){
            int x = coordinates[0];
            int y = coordinates[1];
            board[x][y] = 'O';
        }
    }

    public void dfs(char[][] board, List<int[]> ans, boolean[][] visited, int x, int y){
        if(x < 0 || x > board.length - 1 || y < 0 || y > board[0].length -1 || visited[x][y] || board[x][y] == 'X'){
            return;
        }
        visited[x][y] = true;
        ans.add(new int[]{x, y});
        dfs(board, ans, visited, x + 1, y);
        dfs(board, ans, visited, x - 1, y);
        dfs(board, ans, visited, x, y + 1);
        dfs(board, ans, visited, x, y - 1);

    }
}
