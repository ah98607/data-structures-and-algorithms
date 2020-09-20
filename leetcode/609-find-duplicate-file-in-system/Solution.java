class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        List<List<String>> res = new ArrayList<List<String>>();
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
                        addToMap(paths[i].substring(start, j), dir, map);
                    }
                    start = j + 1;
                }
            }
            addToMap(paths[i].substring(start, paths[i].length()), dir, map);
        }
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            if (entry.getValue().size() > 1) {
                res.add(entry.getValue());
            }
        }
        return res;
    }
    private void addToMap(String s, String dir, Map<String, List<String>> map) {
        int index = s.indexOf("(");
        String fileName = s.substring(0, index);
        String content = s.substring(index + 1);
        if (!map.containsKey(content)) {
            map.put(content, new ArrayList<String>());
        }
        map.get(content).add(dir + "/" + fileName);
    }
}