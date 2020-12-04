class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        List<Integer> res = new ArrayList<Integer>();
        Map<Integer, Set<Integer>> children = new HashMap<Integer, Set<Integer>>();
        for (int i = 0; i < ppid.size(); i++) {
            if (!children.containsKey(ppid.get(i))) {
                children.put(ppid.get(i), new HashSet<Integer>());
            }
            children.get(ppid.get(i)).add(pid.get(i));
        }
        recFind(res, kill, children);
        return res;
    }
    private void recFind(List<Integer> res, int cur, Map<Integer, Set<Integer>> children) {
        if (children.containsKey(cur)) {
            for (Integer child : children.get(cur)) {
                recFind(res, child, children);
            }
        }
        res.add(cur);
    }
}