class Elem {
    String s;
    int f;
    public Elem(String s, int f) {
        this.s = s;
        this.f = f;
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
                if (e1.f != e2.f) {
                    return e2.f - e1.f;
                }
                return e1.s.compareTo(e2.s);
            }
        });
        for (Map.Entry<String, Integer> entry : freq.entrySet()) {
            pq.offer(new Elem(entry.getKey(), entry.getValue()));
        }
        while (k > 0) {
            res.add(pq.poll().s);
            k--;
        }
        return res;
    }
}