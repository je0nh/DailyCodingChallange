public class TrieNode {
    TrieNode[] trie = new TrieNode[26];
    boolean end = false;
}

class WordDictionary {
    private TrieNode root = new TrieNode();

    public WordDictionary() {
        
    }
    
    public void addWord(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            int c = word.charAt(i) - 'a';
            if (node.trie[c] == null) {
                node.trie[c] = new TrieNode();
            }
            node = node.trie[c];
        }
        node.end = true;
    }
    
    public boolean search(String word) {
        Queue<TrieNode> q = new LinkedList<>();
        q.add(root);

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int size = q.size();

            Queue<TrieNode> nextLevel = new LinkedList<>();

            while (size-- > 0) {
                TrieNode node = q.poll();
                if (node == null) continue;

                if (c == '.') {
                    for (TrieNode child : node.trie) {
                        if (child != null) nextLevel.add(child);
                    }
                } else {
                    TrieNode next = node.trie[c - 'a'];
                    if (next != null) nextLevel.add(next);
                }
            }
            q = nextLevel;
        }

        for (TrieNode node : q) {
            if (node.end) return true;
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