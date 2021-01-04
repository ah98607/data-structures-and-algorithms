class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<String>();
        if (s.length() < 4 || s.length() > 12) {
            return res;
        }
        recFind(res, new ArrayList<String>(), 0, s);
        return res;
    }
    private void recFind(List<String> res, List<String> sList, int start, String s) {
        if (start >= s.length() || sList.size() == 4) {
            if (start == s.length() && sList.size() == 4) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < sList.size(); i++) {
                    sb.append((sb.length() == 0 ? "" : ".") + sList.get(i));
                }
                res.add(sb.toString());
            }
            return;
        }
        for (int i = start; i < s.length(); i++) {
            String temp = s.substring(start, i + 1);
            if (valid(temp)) {
                sList.add(temp);
                recFind(res, sList, i + 1, s);
                sList.remove(sList.size() - 1);
            }
            else {
                return;
            }
        }
    }
    private boolean valid(String s) {
        if (s.equals("0")) {
            return true;
        }
        if (s.charAt(0) == '0') {
            return false;
        }
        int num = Integer.parseInt(s);
        return num >= 1 && num <= 255;
    }
}