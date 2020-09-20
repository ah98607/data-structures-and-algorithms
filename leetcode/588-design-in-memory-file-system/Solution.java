class Node {
    String name;
    Map<String, Node> children;
    boolean isFile;
    String content;
    public Node(String name, String content) {
        this.name = name;
        this.content = content;
        isFile = true;
    }
    public Node(String name) {
        this.name = name;
        children = new TreeMap<String, Node>();
    }
}
class FileSystem {
    Node root;
    public FileSystem() {
        root = new Node("");
    }
    
    public List<String> ls(String path) {
        List<String> res = new ArrayList<String>();
        if (path.equals("/")) {
            for (Map.Entry<String, Node> entry : root.children.entrySet()) {
                res.add(entry.getValue().name);
            }
            return res;
        }
        Node cur = root;
        int start = 0;
        for (int i = 0; i < path.length(); i++) {
            if (path.charAt(i) == '/') {
                if (i != start) {
                    String temp = path.substring(start, i);
                    if (cur.children.containsKey(temp)) {
                        cur = cur.children.get(temp);
                    }
                    else {
                        return res;
                    }
                }
                start = i + 1;
            }
        }
        String temp = path.substring(start, path.length());
        if (cur.children.containsKey(temp)) {
            cur = cur.children.get(temp);
            if (cur.isFile) {
                res.add(cur.name);
            }
            else {
                for (Map.Entry<String, Node> entry : cur.children.entrySet()) {
                    res.add(entry.getValue().name);
                }
            }
        }
        return res;
    }
    
    public void mkdir(String path) {
        Node cur = root;
        int start = 0;
        for (int i = 0; i < path.length(); i++) {
            if (path.charAt(i) == '/') {
                if (i != start) {
                    String temp = path.substring(start, i);
                    if (!cur.children.containsKey(temp)) {
                        cur.children.put(temp, new Node(temp));
                    }
                    cur = cur.children.get(temp);
                }
                start = i + 1;
            }
        }
        String temp = path.substring(start, path.length());
        if (!cur.children.containsKey(temp)) {
            cur.children.put(temp, new Node(temp));
        }
    }
    
    public void addContentToFile(String filePath, String content) {
        Node cur = root;
        int start = 0;
        for (int i = 0; i < filePath.length(); i++) {
            if (filePath.charAt(i) == '/') {
                if (i != start) {
                    String temp = filePath.substring(start, i);
                    if (!cur.children.containsKey(temp)) {
                        cur.children.put(temp, new Node(temp));
                    }
                    cur = cur.children.get(temp);
                }
                start = i + 1;
            }
        }
        String temp = filePath.substring(start, filePath.length());
        if (!cur.children.containsKey(temp)) {
            cur.children.put(temp, new Node(temp, content));
        }
        else {
            cur.children.get(temp).content += content;
        }
    }
    
    public String readContentFromFile(String filePath) {
        Node cur = root;
        int start = 0;
        for (int i = 0; i < filePath.length(); i++) {
            if (filePath.charAt(i) == '/') {
                if (i != start) {
                    String temp = filePath.substring(start, i);
                    if (!cur.children.containsKey(temp)) {
                        return "";
                    }
                    cur = cur.children.get(temp);
                }
                start = i + 1;
            }
        }
        String temp = filePath.substring(start, filePath.length());
        if (cur.children.containsKey(temp)) {
            return cur.children.get(temp).content;
        }
        return "";
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