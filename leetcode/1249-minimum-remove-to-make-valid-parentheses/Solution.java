class Solution {
    public String minRemoveToMakeValid(String s) {
        if (s.length() == 0) {
            return "";
        }
        Stack<Integer> stack = new Stack<Integer>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(sb.length());
                sb.append(s.charAt(i));
            }
            else if (s.charAt(i) == ')') {
                if (!stack.isEmpty()) {
                    sb.append(s.charAt(i));
                    stack.pop();
                }
            }
            else {
                sb.append(s.charAt(i));
            }
        }
        while (!stack.isEmpty()) {
            sb.deleteCharAt(stack.pop());
        }
        return sb.toString();
    }
}