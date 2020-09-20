class Elem {
    int val;
    int freq;
    public Elem(int val, int freq) {
        this.val = val;
        this.freq = freq;
    }
}
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (!freq.containsKey(nums[i])) {
                freq.put(nums[i], 1);
            }
            else {
                freq.put(nums[i], 1 + freq.get(nums[i]));
            }
        }
        Queue<Elem> pq = new PriorityQueue<Elem>(new Comparator<Elem>() {
            public int compare(Elem e1, Elem e2) {
                return e2.freq - e1.freq;
            }
        });
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            pq.offer(new Elem(entry.getKey(), entry.getValue()));
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = pq.poll().val;
        }
        return res;
    }
}