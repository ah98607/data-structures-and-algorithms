class ListNode {
    int key;
    int val;
    int freq;
    ListNode prev;
    ListNode next;
    public ListNode(int key, int val) {
        this.key = key;
        this.val = val;
        freq = 1;
    }
}
class LFUCache {
    Map<Integer, ListNode> map;
    int capacity;
    ListNode dHead;
    ListNode dTail;
    public LFUCache(int capacity) {
        map = new HashMap<Integer, ListNode>();
        this.capacity = capacity;
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
        temp.freq++;
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
    private void remove(ListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    private void add(ListNode node) {
        ListNode cur = dHead.next;
        while (cur != dTail && cur.freq <= node.freq) {
            cur = cur.next;
        }
        node.prev = cur.prev;
        cur.prev.next = node;
        node.next = cur;
        cur.prev = node;
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */