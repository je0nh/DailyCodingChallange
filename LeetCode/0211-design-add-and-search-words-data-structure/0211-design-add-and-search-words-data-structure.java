class Trie {
    private Trie[] node;
    private boolean isEnd;

    public Trie() {
        this.node = new Trie[26];
        this.isEnd = false;
    }

    public Trie[] getNode() {
        return node;
    }

    public boolean getIsEnd() {
        return isEnd;
    }

    public void setNode(Trie[] node) {
        this.node = node;
    }

    public void setIsEnd(boolean isEnd) {
        this.isEnd = isEnd;
    }
}

class WordDictionary {
    private Trie root;
    private Set<Integer> check = new HashSet<>();

    public WordDictionary() {
        this.root = new Trie();
    }
    
    public void addWord(String word) {
        Trie node = root;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (node.getNode()[idx] == null) {
                node.getNode()[idx] = new Trie();
                check.add(idx);
            }
            node = node.getNode()[idx];
        }

        // 마지막 글자 표시
        node.setIsEnd(true);
    }
    
    public boolean search(String word) {
        Queue<Pair<Trie, Integer>> q = new LinkedList<>();
        q.add(new Pair<>(root, 0));

        while (!q.isEmpty()) {
            Pair<Trie, Integer> current = q.poll();
            Trie node = current.getKey();
            Integer idx = current.getValue();

            if (idx == word.length()) {
                if (node.getIsEnd()) return true;
                continue;
            }

            char c = word.charAt(idx);
            if (c == '.') {
                for (Trie trie : node.getNode()) {
                    if (trie != null) {
                        q.add(new Pair<>(trie, idx + 1));
                    }
                }
            } else {
                int charToInt = c - 'a';
                Trie trie = node.getNode()[charToInt];
                if (trie != null) {
                    q.add(new Pair<>(trie, idx + 1));
                }
            }
        }

        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */