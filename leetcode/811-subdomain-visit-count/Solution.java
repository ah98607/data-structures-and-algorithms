class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        List<String> res = new ArrayList<String>();
        if (cpdomains.length == 0) {
            return res;
        }
        Map<String, Integer> freq = new HashMap<String, Integer>();
        for (int i = 0; i < cpdomains.length; i++) {
            int start = 0;
            int count = 0;
            for (int j = 0; j < cpdomains[i].length(); j++) {
                if (cpdomains[i].charAt(j) == ' ' || cpdomains[i].charAt(j) == '.') {
                    if (cpdomains[i].charAt(j) == ' ') {
                        count = Integer.parseInt(cpdomains[i].substring(start, j));
                    }
                    String temp = cpdomains[i].substring(j + 1);
                    if (!freq.containsKey(temp)) {
                        freq.put(temp, count);
                    }
                    else {
                        freq.put(temp, count + freq.get(temp));
                    }
                    start = j + 1;
                }
            }
        }
        for (Map.Entry<String, Integer> entry : freq.entrySet()) {
            res.add(entry.getValue() + " " + entry.getKey());
        }
        return res;
    }
}