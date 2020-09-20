class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < num.length(); i++) {
            while (k > 0 && !stack.isEmpty() && num.charAt(i) < stack.peek()) {
                stack.pop();
                k--;
            }
            stack.push(num.charAt(i));
        }
        while (k > 0 && !stack.isEmpty()) {
            stack.pop();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        sb = sb.reverse();
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) != '0') {
                return sb.toString().substring(i);
            }
        }
        return "0";
    }
}