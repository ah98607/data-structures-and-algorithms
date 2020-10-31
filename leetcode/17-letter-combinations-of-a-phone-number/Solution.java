class Solution {
    final String[] chars = {"", "", "abc", "def", "ghi", "jkl", "mno", "prqs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<String>();
        if (digits.length() == 0) {
            return res;
        }
        recFind(res, new StringBuilder(), digits, chars);
        return res;
    }
    private void recFind(List<String> res, StringBuilder sb, String s, String[] chars) {
        if (s.length() == 0) {
            res.add(sb.toString());
            return;
        }
        int num = s.charAt(0) - '0';
        for (int i = 0; i < chars[num].length(); i++) {
            sb.append(chars[num].charAt(i));
            recFind(res, sb, s.substring(1), chars);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}