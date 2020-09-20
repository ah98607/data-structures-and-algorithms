class Solution {
    public int[][] highFive(int[][] items) {
        Map<Integer, Queue<Integer>> map = new TreeMap<Integer, Queue<Integer>>();
        for (int i = 0; i < items.length; i++) {
            if (!map.containsKey(items[i][0])) {
                map.put(items[i][0], new PriorityQueue<Integer>(new Comparator<Integer>() {
                    public int compare(Integer i1, Integer i2) {
                        return i2 - i1;
                    }
                }));
            }
            map.get(items[i][0]).offer(items[i][1]);
        }
        int[][] res = new int[map.size()][2];
        int index = 0;
        for (Map.Entry<Integer, Queue<Integer>> entry : map.entrySet()) {
            res[index][0] = entry.getKey();
            int total = 0;
            for (int i = 0; i < 5; i++) {
                total += entry.getValue().poll();
            }
            res[index++][1] = total / 5;
        }
        return res;
    }
}