class Solution {
    public String simplifyPath(String path) {
        if (path.length() == 0) {
            return "/";
        }
        List<String> fields = new ArrayList<String>();
        int start = 0;
        for (int i = 0; i < path.length(); i++) {
            if (path.charAt(i) == '/') {
                add(path.substring(start, i), fields);
                start = i + 1;
            }
        }
        add(path.substring(start, path.length()), fields);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < fields.size(); i++) {
            sb.append("/" + fields.get(i));
        }
        if (sb.length() == 0) {
            return "/";
        }
        return sb.toString();
    }
    private void add(String s, List<String> fields) {
        if (s.length() == 0 || s.equals(".")) {
            return;
        }
        if (s.equals("..")) {
            if (!fields.isEmpty()) {
                fields.remove(fields.size() - 1);
            }
            return;
        }
        fields.add(s);
    }
}