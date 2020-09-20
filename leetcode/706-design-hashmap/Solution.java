class ListNode {
    int key;
    int val;
    ListNode next;
    public ListNode(int key, int val) {
        this.key = key;
        this.val = val;
    }
}
class MyHashMap {
    ListNode[] arr;
    /** Initialize your data structure here. */
    public MyHashMap() {
        arr = new ListNode[100];
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        ListNode cur = arr[key % 100];
        ListNode prev = null;
        while (cur != null) {
            if (cur.key == key) {
                cur.val = value;
                return;
            }
            prev = cur;
            cur = cur.next;
        }
        if (prev != null) {
            prev.next = new ListNode(key, value);
        }
        else {
            arr[key % 100] = new ListNode(key, value);
        }
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        ListNode cur = arr[key % 100];
        while (cur != null) {
            if (cur.key == key) {
                return cur.val;
            }
            cur = cur.next;
        }
        return -1;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        ListNode cur = arr[key % 100];
        ListNode prev = null;
        while (cur != null) {
            if (cur.key == key) {
                if (prev != null) {
                    prev.next = cur.next;
                }
                else {
                    arr[key % 100] = cur.next;
                }
                return;
            }
            prev = cur;
            cur = cur.next;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */