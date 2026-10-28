
class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();

        // Build Trie
        for (String s : words) {
            addWord(root, s);
        }

        List<String> ans = new ArrayList<>();

        // Try starting DFS from every board cell
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root, ans);
            }
        }

        return ans;
    }

    private void addWord(TrieNode root, String s) {
        TrieNode cur = root;

        for (char c : s.toCharArray()) {
            int index = c - 'a';

            if (cur.letters[index] == null) {
                cur.letters[index] = new TrieNode();
            }

            cur = cur.letters[index];
        }

        cur.word = s;
    }

    private void dfs(char[][] board, int row, int col,
                     TrieNode node, List<String> ans) {

        // Check boundaries
        if (row < 0 || row >= board.length ||
            col < 0 || col >= board[0].length) {
            return;
        }

        char c = board[row][col];

        // Already visited this cell
        if (c == '#') {
            return;
        }

        int index = c - 'a';

        // No word in the Trie has this prefix
        if (node.letters[index] == null) {
            return;
        }

        // Move to the matching Trie node
        TrieNode next = node.letters[index];

        // Found a complete word
        if (next.word != null) {
            ans.add(next.word);
            next.word = null; // Prevent duplicates
        }

        // Mark current cell as visited
        board[row][col] = '#';

        // Explore all four directions
        dfs(board, row + 1, col, next, ans);
        dfs(board, row - 1, col, next, ans);
        dfs(board, row, col + 1, next, ans);
        dfs(board, row, col - 1, next, ans);

        // Backtrack
        board[row][col] = c;
    }
}

class TrieNode {
    TrieNode[] letters;
    String word;

    public TrieNode() {
        letters = new TrieNode[26];
        word = null;
    }
}