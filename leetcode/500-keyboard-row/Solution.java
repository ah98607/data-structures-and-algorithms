class Solution {
    final String charsInRow1 = "qwertyuiopQWERTYUIOP";
    final String charsInRow2 = "asdfghjklASDFGHJKL";
    public String[] findWords(String[] words) {
        if (words.length == 0) {
            return new String[0];
        }
        List<String> sList = new ArrayList<String>();
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() < 2) {
                sList.add(words[i]);
                continue;
            }
            int row = getRow(words[i].charAt(0));
            boolean sameRow = true;
            for (int j = 1; j < words[i].length(); j++) {
                if (row != getRow(words[i].charAt(j))) {
                    sameRow = false;
                    break;
                }
            }
            if (sameRow) {
                sList.add(words[i]);
            }
        }
        String[] res = new String[sList.size()];
        for (int i = 0; i < sList.size(); i++) {
            res[i] = sList.get(i);
        }
        return res;
    }
    private int getRow(char c) {
        if (charsInRow1.indexOf(c) >= 0) {
            return 1;
        }
        if (charsInRow2.indexOf(c) >= 0) {
            return 2;
        }
        return 3;
    }
}