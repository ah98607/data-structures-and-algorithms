class Solution {
    final String[] chars = {"", "", "abc", "def", "ghi", "jkl", "mno", "prqs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<String>();
        if (digits.length() == 0) {
            return res;
        }
        recFind(res, new StringBuilder(), chars, digits);
        return res;
    }
    private void recFind(List<String> res, StringBuilder sb, String[] chars, String digits) {
        if (digits.length() == 0) {
            res.add(sb.toString());
            return;
        }
        int index = digits.charAt(0) - '0';
        for (int i = 0; i < chars[index].length(); i++) {
            sb.append(chars[index].charAt(i));
            recFind(res, sb, chars, digits.substring(1));
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}