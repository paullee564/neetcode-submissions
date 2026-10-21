class Solution {
    public boolean exist(char[][] board, String word) {
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (search(board, word, 0, r, c)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean search(char[][] board, String word,
                          int index, int row, int col) {

        // Invalid position
        if (row < 0 || row >= board.length ||
            col < 0 || col >= board[0].length) {
            return false;
        }

        // Wrong letter or already visited
        if (board[row][col] != word.charAt(index)) {
            return false;
        }

        // Successfully matched the last letter
        if (index == word.length() - 1) {
            return true;
        }

        // Mark current cell as visited
        char original = board[row][col];
        board[row][col] = '#';

        // Explore four adjacent cells
        boolean found =
            search(board, word, index + 1, row + 1, col) ||
            search(board, word, index + 1, row - 1, col) ||
            search(board, word, index + 1, row, col + 1) ||
            search(board, word, index + 1, row, col - 1);

        // Backtrack: restore cell
        board[row][col] = original;

        return found;
    }
}