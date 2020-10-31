class Elem {
    String word;
    int freq;
    public Elem(String word, int freq) {
        this.word = word;
        this.freq = freq;
    }
}
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> res = new ArrayList<String>();
        Map<String, Integer> freq = new HashMap<String, Integer>();
        for (int i = 0; i < words.length; i++) {
            if (!freq.containsKey(words[i])) {
                freq.put(words[i], 1);
            }
            else {
                freq.put(words[i], 1 + freq.get(words[i]));
            }
        }
        Queue<Elem> pq = new PriorityQueue<Elem>(new Comparator<Elem>() {
            public int compare(Elem e1, Elem e2) {
                if (e1.freq != e2.freq) {
                    return e2.freq - e1.freq;
                }
                return e1.word.compareTo(e2.word);
            }
        });
        for (Map.Entry<String, Integer> entry : freq.entrySet()) {
            pq.offer(new Elem(entry.getKey(), entry.getValue()));
        }
        for (int i = 0; i < k; i++) {
            res.add(pq.poll().word);
        }
        return res;
    }
}