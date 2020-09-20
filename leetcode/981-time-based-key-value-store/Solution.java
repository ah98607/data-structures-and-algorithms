class Elem {
    String val;
    int timestamp;
    public Elem(String val, int timestamp) {
        this.val = val;
        this.timestamp = timestamp;
    }
}
class TimeMap {
    Map<String, List<Elem>> map;
    /** Initialize your data structure here. */
    public TimeMap() {
        map = new HashMap<String, List<Elem>>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<Elem>());
        }
        map.get(key).add(new Elem(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        if (map.containsKey(key)) {
            for (int i = map.get(key).size() - 1; i >= 0; i--) {
                if (map.get(key).get(i).timestamp <= timestamp) {
                    return map.get(key).get(i).val;
                }
            }
        }
        return "";
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */