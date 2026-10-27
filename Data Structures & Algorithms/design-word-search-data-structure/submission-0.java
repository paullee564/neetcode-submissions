class WordDictionary {
    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode cur = root;

        for (char c : word.toCharArray()) {
            int index = c - 'a';

            if (cur.letters[index] == null) {
                cur.letters[index] = new TrieNode();
            }

            cur = cur.letters[index];
        }

        cur.isEnd = true;
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int index, TrieNode node) {
        if (index == word.length()) {
            return node.isEnd;
        }

        char c = word.charAt(index);

        if (c == '.') {
            for (TrieNode child : node.letters) {
                if (child != null && dfs(word, index + 1, child)) {
                    return true;
                }
            }

            return false;
        }

        int pos = c - 'a';

        if (node.letters[pos] == null) {
            return false;
        }

        return dfs(word, index + 1, node.letters[pos]);
    }
}

class TrieNode {
    TrieNode[] letters;
    boolean isEnd;

    public TrieNode() {
        letters = new TrieNode[26];
        isEnd = false;
    }
}