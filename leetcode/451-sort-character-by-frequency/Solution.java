class Elem {
    char c;
    int freq;
    public Elem(char c, int freq) {
        this.c = c;
        this.freq = freq;
    }
}
class Solution {
    public String frequencySort(String s) {
        if (s.length() == 0) {
            return "";
        }
        Map<Character, Integer> freq = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            if (!freq.containsKey(s.charAt(i))) {
                freq.put(s.charAt(i), 1);
            }
            else {
                freq.put(s.charAt(i), 1 + freq.get(s.charAt(i)));
            }
        }
        Queue<Elem> pq = new PriorityQueue<Elem>(new Comparator<Elem>() {
            public int compare(Elem e1, Elem e2) {
                return e2.freq - e1.freq;
            }
        });
        for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
            pq.offer(new Elem(entry.getKey(), entry.getValue()));
        }
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            Elem e = pq.poll();
            for (int i = 0; i < e.freq; i++) {
                sb.append(e.c);
            }
        }
        return sb.toString();
    }
}