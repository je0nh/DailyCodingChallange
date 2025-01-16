class Solution {
    class Trie {
        private Trie[] trie;
        private boolean isEnd;

        public Trie() {
            this.trie = new Trie[26];
            this.isEnd = false;
        }
    }

    private Trie root = new Trie();
    private int m, n;
    private List<String> ans = new ArrayList<>();

    public List<String> findWords(char[][] board, String[] words) {
        for (String word : words) {
            createTrie(word);
        }

        m = board.length;
        n = board[0].length;        

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, i, j, root, "");
            }
        }
        return ans;   
    }

    private void dfs(char[][] board, int row, int col, Trie node, String path) {
        if (row < 0 || row >= m || col < 0 || col >= n || board[row][col] == '#') return;

        char c = board[row][col];
        int idx = c - 'a';

        if (node.trie[idx] == null) return;

        node = node.trie[idx];
        path += c;

        board[row][col] = '#';

        if (node.isEnd) {
            ans.add(path);
            node.isEnd = false;
        }

        dfs(board, row - 1, col, node, path);
        dfs(board, row + 1, col, node, path);
        dfs(board, row, col - 1, node, path);
        dfs(board, row, col + 1, node, path);

        board[row][col] = c;
    }

    private void createTrie(String word) {
        Trie node = root;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (node.trie[idx] == null) {
                node.trie[idx] = new Trie();
            }
            node = node.trie[idx];
        }
        node.isEnd = true;
    }
}