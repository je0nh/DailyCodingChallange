class Trie {
    private Set<String> starts = new HashSet<>();
    private Set<String> trie = new HashSet<>();

    public Trie() {
        
    }
    
    public void insert(String word) {
        trie.add(word);
        addStart(word);
    }
    
    public boolean search(String word) {
        if (trie.contains(word)) return true;
        return false;
    }
    
    public boolean startsWith(String prefix) {
        if (starts.contains(prefix)) return true;
        return false;
    }

    private void addStart(String word) {
        for (int i = 0; i < word.length(); i++) {
            String pattern = word.substring(0, i + 1);
            starts.add(pattern);
        }
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */