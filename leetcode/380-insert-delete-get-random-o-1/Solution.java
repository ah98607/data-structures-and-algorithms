class RandomizedSet {
    List<Integer> iList;
    Map<Integer, Integer> map;
    Random r;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        iList = new ArrayList<Integer>();
        map = new HashMap<Integer, Integer>();
        r = new Random();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        map.put(val, iList.size());
        iList.add(val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        int index = map.get(val);
        map.put(iList.get(iList.size() - 1), index);
        iList.set(index, iList.get(iList.size() - 1));
        map.remove(val);
        iList.remove(iList.size() - 1);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return iList.get(r.nextInt(iList.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */