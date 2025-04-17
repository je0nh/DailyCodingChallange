class RandomizedSet {
    private List<Integer> list = new ArrayList<>();
    private Map<Integer, Integer> map = new HashMap<>();

    public RandomizedSet() {
        
    }
    
    // val가 없으면 추가하고 true, 있으면 false 반환
    public boolean insert(int val) {
        if (map.containsKey(val)) return false;

        list.add(val);
        int idx = list.size() - 1;
        map.put(val, idx);
        // System.out.println(list.toString());
        return true;
    }
    
    // val이 존재하면 삭제하고 true, 없으면 false 반환
    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;

        int idx = map.get(val);
        int lastVal = list.get(list.size() - 1);

        list.set(idx, lastVal);
        map.put(lastVal, idx);

        list.remove(list.size() - 1);
        map.remove(val);
        // System.out.println(list.toString());
        return true;
    }
    
    // 임의의 원소 반환
    public int getRandom() {
        Random rand = new Random();
        // System.out.println(list.toString());
        return list.get(rand.nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */