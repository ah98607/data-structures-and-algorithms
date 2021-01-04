class Node {
    boolean isFile;
    String content;
    Map<String, Node> children;
    public Node(String content) {
        this.content = content;
        isFile = true;
    }
    public Node() {
        children = new TreeMap<String, Node>();
    }
}
class FileSystem {
    Node root;
    public FileSystem() {
        root = new Node();
    }
    
    public List<String> ls(String path) {
        List<String> res = new ArrayList<String>();
        if (path.equals("/")) {
            for (Map.Entry<String, Node> entry : root.children.entrySet()) {
                res.add(entry.getKey());
            }
            return res;
        }
        int start = 1;
        Node cur = root;
        for (int i = 1; i < path.length(); i++) {
            if (path.charAt(i) == '/') {
                String temp = path.substring(start, i);
                cur = cur.children.get(temp);
                start = i + 1;
            }
        }
        String temp = path.substring(start, path.length());
        cur = cur.children.get(temp);
        if (cur.isFile) {
            res.add(temp);
        }
        else {
            for (Map.Entry<String, Node> entry : cur.children.entrySet()) {
                res.add(entry.getKey());
            }
        }
        return res;
    }
    
    public void mkdir(String path) {
        if (path.equals("/")) {
            return;
        }
        int start = 1;
        Node cur = root;
        for (int i = 1; i < path.length(); i++) {
            if (path.charAt(i) == '/') {
                String temp = path.substring(start, i);
                if (!cur.children.containsKey(temp)) {
                    cur.children.put(temp, new Node());
                }
                cur = cur.children.get(temp);
                start = i + 1;
            }
        }
        String temp = path.substring(start, path.length());
        if (!cur.children.containsKey(temp)) {
            cur.children.put(temp, new Node());
        }
    }
    
    public void addContentToFile(String filePath, String content) {
        int start = 1;
        Node cur = root;
        for (int i = 1; i < filePath.length(); i++) {
            if (filePath.charAt(i) == '/') {
                String temp = filePath.substring(start, i);
                if (!cur.children.containsKey(temp)) {
                    cur.children.put(temp, new Node());
                }
                cur = cur.children.get(temp);
                start = i + 1;
            }
        }
        String temp = filePath.substring(start, filePath.length());
        if (!cur.children.containsKey(temp)) {
            cur.children.put(temp, new Node(content));
        }
        else {
            cur.children.get(temp).content += content;
        }
    }
    
    public String readContentFromFile(String filePath) {
        int start = 1;
        Node cur = root;
        for (int i = 1; i < filePath.length(); i++) {
            if (filePath.charAt(i) == '/') {
                String temp = filePath.substring(start, i);
                cur = cur.children.get(temp);
                start = i + 1;
            }
        }
        String temp = filePath.substring(start, filePath.length());
        cur = cur.children.get(temp);
        return cur.content;
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * List<String> param_1 = obj.ls(path);
 * obj.mkdir(path);
 * obj.addContentToFile(filePath,content);
 * String param_4 = obj.readContentFromFile(filePath);
 */