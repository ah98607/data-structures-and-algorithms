class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<String>(wordList);
        if (!dict.contains(endWord)) {
            return 0;
        }
        Queue<String> q = new LinkedList<String>();
        q.offer(beginWord);
        int dist = 1;
        while (!q.isEmpty()) {
            int qSize = q.size();
            for (int i = 0; i < qSize; i++) {
                String temp = q.poll();
                if (temp.equals(endWord)) {
                    return dist;
                }
                List<String> nextWords = getNextWords(temp, dict);
                for (String nextWord : nextWords) {
                    q.offer(nextWord);
                }
            }
            dist++;
        }
        return 0;
    }
    private List<String> getNextWords(String s, Set<String> dict) {
        List<String> res = new ArrayList<String>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < 26; j++) {
                String temp = s.substring(0, i) + (char) ('a' + j) + s.substring(i + 1);
                if (dict.contains(temp)) {
                    res.add(temp);
                    dict.remove(temp);
                }
            }
        }
        return res;
    }
}