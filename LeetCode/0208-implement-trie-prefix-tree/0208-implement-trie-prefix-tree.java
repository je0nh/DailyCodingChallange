class Trie {
    List<String> words = new ArrayList<>();

    public Trie() {
        
    }
    
    public void insert(String word) {
        words.add(word);
    }
    
    public boolean search(String word) {
        for (int i = 0; i < words.size(); i++) {
            if (words.get(i).equals(word)) return true;
        }
        return false;
    }
    
    public boolean startsWith(String prefix) {
        for (int i = 0; i < words.size(); i++) {
            if (words.get(i).length() < prefix.length()) continue;
            String s = words.get(i).substring(0,prefix.length());
            if (s.equals(prefix)) return true;
        }
        return false;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */