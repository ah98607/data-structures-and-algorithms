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
            for (int j = 1; j < words[i].length(); j++) {
                int tempRow = getRow(words[i].charAt(j));
                if (tempRow != row) {
                    break;
                }
                if (j == words[i].length() - 1) {
                    sList.add(words[i]);
                }
            }
        }
        String[] res = new String[sList.size()];
        for (int i = 0; i < res.length; i++) {
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