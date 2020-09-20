class Solution {
    public String reverseWords(String s) {
        Stack<String> stack = new Stack<String>();
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                if (i != start) {
                    stack.push(s.substring(start, i));
                }
                start = i + 1;
            }
        }
        if (s.length() != start) {
            stack.push(s.substring(start, s.length()));
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append((sb.length() == 0 ? "" : " ") + stack.pop());
        }
        return sb.toString();
    }
}