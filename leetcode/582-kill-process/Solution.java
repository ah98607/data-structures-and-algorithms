class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        List<Integer> res = new ArrayList<Integer>();
        Map<Integer, Set<Integer>> childrenProcesses = new HashMap<Integer, Set<Integer>>();
        for (int i = 0; i < ppid.size(); i++) {
            if (!childrenProcesses.containsKey(ppid.get(i))) {
                childrenProcesses.put(ppid.get(i), new HashSet<Integer>());
            }
            childrenProcesses.get(ppid.get(i)).add(pid.get(i));
        }
        recFind(res, kill, childrenProcesses);
        return res;
    }
    private void recFind(List<Integer> res, int cur, Map<Integer, Set<Integer>> childrenProcesses) {
        if (childrenProcesses.containsKey(cur)) {
            for (Integer childProcess : childrenProcesses.get(cur)) {
                recFind(res, childProcess, childrenProcesses);
            }
        }
        res.add(cur);
    }
}