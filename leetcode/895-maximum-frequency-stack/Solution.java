class FreqStack {
    Map<Integer, Integer> n2f;
    Map<Integer, List<Integer>> f2ns;
    int maxFreq;
    public FreqStack() {
        n2f = new HashMap<Integer, Integer>();
        f2ns = new HashMap<Integer, List<Integer>>();
    }
    
    public void push(int x) {
        if (!n2f.containsKey(x)) {
            n2f.put(x, 1);
        }
        else {
            n2f.put(x, 1 + n2f.get(x));
        }
        int freq = n2f.get(x);
        maxFreq = Math.max(maxFreq, freq);
        if (!f2ns.containsKey(freq)) {
            f2ns.put(freq, new ArrayList<Integer>());
        }
        f2ns.get(freq).add(x);
    }
    
    public int pop() {
        List<Integer> iList = f2ns.get(maxFreq);
        int temp = iList.get(iList.size() - 1);
        iList.remove(iList.size() - 1);
        if (iList.isEmpty()) {
            maxFreq--;
        }
        n2f.put(temp, n2f.get(temp) - 1);
        return temp;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 */