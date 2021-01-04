class ListNode {
    int key;
    int val;
    ListNode prev;
    ListNode next;
    public ListNode(int key, int val) {
        this.key = key;
        this.val = val;
    }
}
class LRUCache {
    Map<Integer, ListNode> map;
    ListNode dHead;
    ListNode dTail;
    int capacity;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<Integer, ListNode>();
        dHead = new ListNode(0, 0);
        dTail = new ListNode(0, 0);
        dHead.next = dTail;
        dTail.prev = dHead;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        ListNode temp = map.get(key);
        remove(temp);
        add(temp);
        return temp.val;
    }
    
    public void put(int key, int value) {
        if (get(key) != -1) {
            map.get(key).val = value;
            return;
        }
        if (capacity == 0) {
            return;
        }
        if (map.size() == capacity) {
            map.remove(dHead.next.key);
            remove(dHead.next);
        }
        map.put(key, new ListNode(key, value));
        add(map.get(key));
    }
    private void add(ListNode node) {
        dTail.prev.next = node;
        node.prev = dTail.prev;
        node.next = dTail;
        dTail.prev = node;
    }
    private void remove(ListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */