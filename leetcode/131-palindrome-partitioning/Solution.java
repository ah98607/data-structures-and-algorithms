class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<List<String>>();
        recFind(res, new ArrayList<String>(), 0, s);
        return res;
    }
    private void recFind(List<List<String>> res, List<String> sList, int start, String s) {
        if (start == s.length()) {
            res.add(new ArrayList<String>(sList));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            String temp = s.substring(start, i + 1);
            if (palindromic(temp)) {
                sList.add(temp);
                recFind(res, sList, i + 1, s);
                sList.remove(sList.size() - 1);
            }
        }
    }
    private boolean palindromic(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
}