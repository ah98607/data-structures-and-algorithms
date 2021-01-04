class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        List<String> res = new ArrayList<String>();
        if (cpdomains.length == 0) {
            return res;
        }
        Map<String, Integer> freq = new HashMap<String, Integer>();
        for (int i = 0; i < cpdomains.length; i++) {
            int count = 0;
            for (int j = 0; j < cpdomains[i].length(); j++) {
                if (cpdomains[i].charAt(j) == ' ' || cpdomains[i].charAt(j) == '.') {
                    if (cpdomains[i].charAt(j) == ' ') {
                        count = Integer.parseInt(cpdomains[i].substring(0, j));
                    }
                    addToMap(count, cpdomains[i].substring(j + 1), freq);
                }
            }
        }
        for (Map.Entry<String, Integer> entry : freq.entrySet()) {
            res.add(entry.getValue() + " " + entry.getKey());
        }
        return res;
    }
    private void addToMap(int count, String s, Map<String, Integer> freq) {
        if (!freq.containsKey(s)) {
            freq.put(s, count);
        }
        else {
            freq.put(s, count + freq.get(s));
        }
    }
}