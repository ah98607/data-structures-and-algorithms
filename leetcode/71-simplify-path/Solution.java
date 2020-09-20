class Solution {
    public String simplifyPath(String path) {
        if (path.length() == 0) {
            return "/";
        }
        Stack<String> stack = new Stack<String>();
        int start = 0;
        for (int i = 0; i < path.length(); i++) {
            if (path.charAt(i) == '/') {
                addToStack(path.substring(start, i), stack);
                start = i + 1;
            }
        }
        addToStack(path.substring(start, path.length()), stack);
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, "/" + stack.pop());
        }
        if (sb.length() == 0) {
            return "/";
        }
        return sb.toString();
    }
    private void addToStack(String s, Stack<String> stack) {
        if (s.length() == 0 || s.equals(".")) {
            return;
        }
        if (s.equals("..")) {
            if (!stack.isEmpty()) {
                stack.pop();
            }
            return;
        }
        stack.push(s);
    }
}