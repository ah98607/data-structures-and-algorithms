class Solution {
    public List<String> commonChars(String[] A) {
        List<String> res = new ArrayList<String>();
        int[] freq = new int[26];
        for (int i = 0; i < A[0].length(); i++) {
            freq[A[0].charAt(i) - 'a']++;
        }
        for (int i = 1; i < A.length; i++) {
            int[] tempFreq = new int[26];
            for (int j = 0; j < A[i].length(); j++) {
                tempFreq[A[i].charAt(j) - 'a']++;
            }
            for (int j = 0; j < 26; j++) {
                freq[j] = Math.min(freq[j], tempFreq[j]);
            }
        }
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < freq[i]; j++) {
                res.add(String.valueOf((char) ('a' + i)));
            }
        }
        return res;
    }
}