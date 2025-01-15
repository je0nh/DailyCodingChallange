public class TrieNode {
    private TrieNode[] children;
    private boolean isEnd;

    public TrieNode() {
        this.children = new TrieNode[26];
        this.isEnd = false;
    }

    public TrieNode[] getChildren() {
        return children;
    }

    public boolean getIsEnd() {
        return isEnd;
    }

    public void setChildren(TrieNode[] children) {
        this.children = children;
    }

    public void setIsEnd(boolean isEnd) {
        this.isEnd = isEnd;
    }
}

class Trie {
    private TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode trieNode = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (trieNode.getChildren()[index] == null) {
                trieNode.getChildren()[index] = new TrieNode();
            }
            trieNode = trieNode.getChildren()[index];
        }

        // 마지막 단어 표시
        trieNode.setIsEnd(true);
    }
    
    public boolean search(String word) {
        TrieNode trieNode = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (trieNode.getChildren()[index] == null) return false;

            trieNode = trieNode.getChildren()[index];
        }
        return trieNode.getIsEnd();
    }
    
    public boolean startsWith(String prefix) {
        TrieNode trieNode = root;
        for (char c : prefix.toCharArray()) {
            int index = c - 'a';
            if (trieNode.getChildren()[index] == null) return false;

            trieNode = trieNode.getChildren()[index];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */