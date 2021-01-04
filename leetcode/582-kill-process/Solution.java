class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        List<Integer> res = new ArrayList<Integer>();
        Map<Integer, Set<Integer>> childProcesses = new HashMap<Integer, Set<Integer>>();
        for (int i = 0; i < ppid.size(); i++) {
            if (!childProcesses.containsKey(ppid.get(i))) {
                childProcesses.put(ppid.get(i), new HashSet<Integer>());
            }
            childProcesses.get(ppid.get(i)).add(pid.get(i));
        }
        recFind(res, kill, childProcesses);
        return res;
    }
    private void recFind(List<Integer> res, int cur, Map<Integer, Set<Integer>> childProcesses) {
        if (childProcesses.containsKey(cur)) {
            for (Integer childProcess : childProcesses.get(cur)) {
                recFind(res, childProcess, childProcesses);
            }
        }
        res.add(cur);
    }
}