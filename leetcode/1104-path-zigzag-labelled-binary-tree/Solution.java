class Solution {
    public List<Integer> pathInZigZagTree(int label) {
        List<Integer> result = new ArrayList<Integer>();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(); // node -> parent
        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(1);
        map.put(1, -1);
        int level = 0;
        int count = 1;
        while (!q.isEmpty() && !map.containsKey(label)) {
            level++;
            int qSize = q.size();
            if (level % 2 == 0) {
                for (int i = 0; i < qSize; i++) {
                    int parent = q.poll();
                    q.offer(count + 1);
                    map.put(count + 1, parent);
                    count++;
                    q.offer(count + 1);
                    map.put(count + 1, parent);
                    count++;
                }
            }
            else {
                int help = count + 1 + count + 2 * qSize;
                for (int i = 0; i < qSize; i++) {
                    int parent = q.poll();
                    q.offer(help - (count + 1));
                    map.put(help - (count + 1), parent);
                    count++;
                    q.offer(help - (count + 1));
                    map.put(help - (count + 1), parent);
                    count++;
                }
            }
        }
        int current = label;
        while (true) {
            result.add(current);
            current = map.get(current);
            if (current == -1) {
                break;
            }
        }
        Collections.reverse(result);
        return result;
    }
}