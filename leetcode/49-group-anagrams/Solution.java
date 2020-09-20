class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<List<String>>();
        if (strs.length == 0) {
            return res;
        }
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (int i = 0; i < strs.length; i++) {
            String s = getString(strs[i]);
            if (!map.containsKey(s)) {
                map.put(s, new ArrayList<String>());
            }
            map.get(s).add(strs[i]);
        }
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            res.add(entry.getValue());
        }
        return res;
    }
    private String getString(String s) {
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < freq[i]; j++) {
                sb.append((char) (i + 'a'));
            }
        }
        return sb.toString();
    }
}