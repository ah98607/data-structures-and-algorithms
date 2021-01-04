class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        List<String> res = new ArrayList<String>();
        if (tickets.size() == 0) {
            return res;
        }
        Map<String, Queue<String>> adj = new HashMap<String, Queue<String>>();
        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);
            if (!adj.containsKey(from)) {
                adj.put(from, new PriorityQueue<String>());
            }
            adj.get(from).offer(to);
        }
        recFind(res, "JFK", adj);
        Collections.reverse(res);
        return res;
    }
    private void recFind(List<String> res, String cur, Map<String, Queue<String>> adj) {
        while (adj.containsKey(cur) && !adj.get(cur).isEmpty()) {
            recFind(res, adj.get(cur).poll(), adj);
        }
        res.add(cur);
    }
}