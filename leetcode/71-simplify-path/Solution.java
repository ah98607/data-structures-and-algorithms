class Solution {
    public String simplifyPath(String path) {
        List<String> sList = new ArrayList<String>();
        int start = 0;
        for (int i = 0; i < path.length(); i++) {
            if (path.charAt(i) == '/') {
                addToList(path.substring(start, i), sList);
                start = i + 1;
            }
        }
        addToList(path.substring(start, path.length()), sList);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sList.size(); i++) {
            sb.append("/" + sList.get(i));
        }
        if (sb.length() == 0) {
            return "/";
        }
        return sb.toString();
    }
    private void addToList(String s, List<String> sList) {
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