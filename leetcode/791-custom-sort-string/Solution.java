class Solution {
    public String customSortString(String S, String T) {
        if (T == null || T.length() == 0) {
            return "";
        }
        if (S == null || S.length() == 0) {
            return T;
        }
        Map<Character, Integer> freq = new HashMap<Character, Integer>();
        for (int i = 0; i < T.length(); i++) {
            if (!freq.containsKey(T.charAt(i))) {
                freq.put(T.charAt(i), 1);
            }
            else {
                freq.put(T.charAt(i), 1 + freq.get(T.charAt(i)));
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            if (freq.containsKey(S.charAt(i))) {
                for (int j = 0; j < freq.get(S.charAt(i)); j++) {
                    sb.append(S.charAt(i));
                }
                freq.remove(S.charAt(i));
            }
        }
        for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
            for (int i = 0; i < entry.getValue(); i++) {
                sb.append(entry.getKey());
            }
        }
        return sb.toString();
    }
}