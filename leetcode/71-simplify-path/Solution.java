class Solution {
    public String simplifyPath(String path) {
        if (path.length() == 0) {
            return "/";
        }
        List<String> sList = new ArrayList<String>();
        int start = 0;
        for (int i = 0; i < path.length(); i++) {
            if (path.charAt(i) == '/') {
                add(path.substring(start, i), sList);
                start = i + 1;
            }
        }
        add(path.substring(start, path.length()), sList);
        StringBuilder sb = new StringBuilder();
        for (String s : sList) {
            sb.append("/" + s);
        }
        if (sb.length() == 0) {
            return "/";
        }
        return sb.toString();
    }
    private void add(String s, List<String> sList) {
        if (s.length() == 0 || s.equals(".")) {
            return;
        }
        if (s.equals("..")) {
            if (!sList.isEmpty()) {
                sList.remove(sList.size() - 1);
            }
            return;
        }
        sList.add(s);
    }
}