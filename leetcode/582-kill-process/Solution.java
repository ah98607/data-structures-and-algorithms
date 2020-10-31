class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        List<Integer> res = new ArrayList<Integer>();
        if (ppid.isEmpty()) {
            return res;
        }
        Map<Integer, List<Integer>> childProcesses = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < ppid.size(); i++) {
            if (!childProcesses.containsKey(ppid.get(i))) {
                childProcesses.put(ppid.get(i), new ArrayList<Integer>());
            }
            childProcesses.get(ppid.get(i)).add(pid.get(i));
        }
        recFind(res, kill, childProcesses);
        return res;
    }
    private void recFind(List<Integer> res, int kill, Map<Integer, List<Integer>> childProcesses) {
        if (childProcesses.containsKey(kill)) {
            for (Integer childProcess : childProcesses.get(kill)) {
                recFind(res, childProcess, childProcesses);
            }
        }
        res.add(kill);
    }
}