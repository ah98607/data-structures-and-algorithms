class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> result = new ArrayList<String>();
        if (s == null || s.length() == 0) {
            return result;
        }
        Set<String> dict = new HashSet<String>();
        int maxLen = 0;
        for (int i = 0; i < wordDict.size(); i++) {
            dict.add(wordDict.get(i));
            maxLen = Math.max(maxLen, wordDict.get(i).length());
        }
        recFind(result, new ArrayList<String>(), 0, s, dict, maxLen);
        return result;
    }
    private void recFind(List<String> result, List<String> sList, int start, String s, Set<String> dict, int maxLen) {
        if (start == s.length()) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < sList.size(); i++) {
                sb.append(sList.get(i) + ((i == sList.size() - 1) ? "" : " "));
            }
            result.add(sb.toString());
            return;
        }
        
        for (int i = start; i < s.length() && i - start + 1 <= maxLen; i++) {
            if (dict.contains(s.substring(start, i + 1))) {
                sList.add(s.substring(start, i + 1));
                recFind(result, sList, i + 1, s, dict, maxLen);
                sList.remove(sList.size() - 1);
            }
        }
    }
}