public class TrieNode {
    private HashMap<Character, TrieNode> children;
    private boolean isEnd;

    public TrieNode() {
        this.children = new HashMap<>();
        this.isEnd = false;
    }

    public HashMap<Character, TrieNode> getChildren() {
        return children;
    }

    public boolean getIsEnd() {
        return isEnd;
    }

    public void setChildren(HashMap<Character, TrieNode> children) {
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
            trieNode.getChildren().putIfAbsent(c, new TrieNode());
            trieNode = trieNode.getChildren().get(c);
        }

        // 마지막 단어 표시
        trieNode.setIsEnd(true);
    }
    
    public boolean search(String word) {
        TrieNode trieNode = root;
        for (char c : word.toCharArray()) {
            if (!trieNode.getChildren().containsKey(c)) return false;

            trieNode = trieNode.getChildren().get(c);
        }
        return trieNode.getIsEnd();
    }
    
    public boolean startsWith(String prefix) {
        TrieNode trieNode = root;
        for (char c : prefix.toCharArray()) {
            if (!trieNode.getChildren().containsKey(c)) return false;

            trieNode = trieNode.getChildren().get(c);
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