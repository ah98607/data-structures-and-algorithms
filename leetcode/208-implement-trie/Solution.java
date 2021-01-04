class TrieNode {
    Map<Character, TrieNode> next;
    boolean isWord;
    public TrieNode() {
        next = new HashMap<Character, TrieNode>();
    }
}
class Trie {
    TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode cur = root;
        int index = 0;
        while (index < word.length() && cur != null && cur.next.containsKey(word.charAt(index))) {
            cur = cur.next.get(word.charAt(index++));
        }
        while (index < word.length()) {
            cur.next.put(word.charAt(index), new TrieNode());
            cur = cur.next.get(word.charAt(index++));
        }
        cur.isWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode cur = root;
        int index = 0;
        while (index < word.length() && cur != null && cur.next.containsKey(word.charAt(index))) {
            cur = cur.next.get(word.charAt(index++));
        }
        return cur.isWord && index == word.length();
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        int index = 0;
        while (index < prefix.length() && cur != null && cur.next.containsKey(prefix.charAt(index))) {
            cur = cur.next.get(prefix.charAt(index++));
        }
        return index == prefix.length();
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */