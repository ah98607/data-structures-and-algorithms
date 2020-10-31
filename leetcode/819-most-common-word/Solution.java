class Solution {
    String res = "";
    int maxFreq;
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> ban = new HashSet<String>();
        for (int i = 0; i < banned.length; i++) {
            ban.add(banned[i]);
        }
        paragraph = paragraph.toLowerCase();
        Map<String, Integer> freq = new HashMap<String, Integer>();
        int start = 0;
        for (int i = 0; i < paragraph.length(); i++) {
            if (paragraph.charAt(i) < 'a' || paragraph.charAt(i) > 'z') {
                add(paragraph.substring(start, i), freq, ban);
                start = i + 1;
            }
        }
        add(paragraph.substring(start, paragraph.length()), freq, ban);
        return res;
    }
    private void add(String s, Map<String, Integer> freq, Set<String> ban) {
        if (s.length() == 0 || ban.contains(s)) {
            return;
        }
        if (!freq.containsKey(s)) {
            freq.put(s, 1);
        }
        else {
            freq.put(s, 1 + freq.get(s));
        }
        if (freq.get(s) > maxFreq) {
            maxFreq = freq.get(s);
            res = s;
        }
    }
}