class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<String>(wordDict);
        List<List<String>> dp = new ArrayList<List<String>>();
        for (int i = 0; i <= s.length(); i++) {
            dp.add(new ArrayList<String>());
        }
        dp.get(0).add("");
        for (int i = 1; i < dp.size(); i++) {
            for (int j = 0; j < i; j++) {
                String temp = s.substring(j, i);
                if (!dp.get(j).isEmpty() && dict.contains(temp)) {
                    for (int k = 0; k < dp.get(j).size(); k++) {
                        dp.get(i).add((dp.get(j).get(k).equals("") ? "" : dp.get(j).get(k) + " ") + temp);
                    }
                }
            }
        }
        return dp.get(dp.size() - 1);
    }
}