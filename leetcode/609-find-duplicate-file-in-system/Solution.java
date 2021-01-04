class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        List<List<String>> res = new ArrayList<List<String>>();
        if (paths.length == 0) {
            return res;
        }
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (int i = 0; i < paths.length; i++) {
            int start = 0;
            String dir = "";
            for (int j = 0; j < paths[i].length(); j++) {
                if (paths[i].charAt(j) == ' ') {
                    if (start == 0) {
                        dir = paths[i].substring(start, j);
                    }
                    else {
                        addToMap(dir, paths[i].substring(start, j), map);
                    }
                    start = j + 1;
                }
            }
            addToMap(dir, paths[i].substring(start, paths[i].length()), map);
        }
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            if (entry.getValue().size() > 1) {
                res.add(entry.getValue());
            }
        }
        return res;
    }
    private void addToMap(String dir, String s, Map<String, List<String>> map) {
        int index = s.indexOf("(");
        String content = s.substring(index + 1);
        String fileName = s.substring(0, index);
        if (!map.containsKey(content)) {
            map.put(content, new ArrayList<String>());
        }
        map.get(content).add(dir + "/" + fileName);
    }
}