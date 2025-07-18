class LRUCache {
    private List<Integer> linkedList = new LinkedList<>();
    private Map<Integer, Integer> map = new HashMap<>();
    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) return -1;

        linkedList.remove((Integer) key);
        linkedList.add(key);
        return map.get(key);
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            linkedList.remove((Integer) key);
        } else if (linkedList.size() == capacity) {
            int removeKey = linkedList.removeFirst();
            map.remove(removeKey);
        }

        linkedList.addLast(key);
        map.put(key, value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */