class Solution {
    final String[] chars = {"", "", "abc", "def", "ghi", "jkl", "mno", "prqs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<String>();
        if (digits.length() == 0) {
            return res;
        }
        recFind(res, new StringBuilder(), digits);
        return res;
    }
    private void recFind(List<String> res, StringBuilder sb, String s) {
        if (s.length() == 0) {
            res.add(sb.toString());
            return;
        }
        int index = s.charAt(0) - '0';
        for (int i = 0; i < chars[index].length(); i++) {
            sb.append(chars[index].charAt(i));
            recFind(res, sb, s.substring(1));
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}