class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        if (n == 0) {
            return res;
        }
        recFind(res, new StringBuilder(), n, n);
        return res;
    }
    private void recFind(List<String> res, StringBuilder sb, int left, int right) {
        if (left == 0 && right == 0) {
            res.add(sb.toString());
            return;
        }
        if (left > 0) {
            sb.append("(");
            recFind(res, sb, left - 1, right);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (right > 0 && left < right) {
            sb.append(")");
            recFind(res, sb, left, right - 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}