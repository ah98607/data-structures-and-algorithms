class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> res = new ArrayList<List<String>>();
        Map<String, Set<Integer>> e2ids = new HashMap<String, Set<Integer>>();
        for (int i = 0; i < accounts.size(); i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                if (!e2ids.containsKey(accounts.get(i).get(j))) {
                    e2ids.put(accounts.get(i).get(j), new HashSet<Integer>());
                }
                e2ids.get(accounts.get(i).get(j)).add(i);
            }
        }
        boolean[] vis = new boolean[accounts.size()];
        for (int i = 0; i < accounts.size(); i++) {
            if (!vis[i]) {
                Queue<Integer> q = new LinkedList<Integer>();
                Set<String> emails = new TreeSet<String>();
                q.offer(i);
                vis[i] = true;
                while (!q.isEmpty()) {
                    int id = q.poll();
                    for (int j = 1; j < accounts.get(id).size(); j++) {
                        String email = accounts.get(id).get(j);
                        emails.add(email);
                        for (Integer associatedId : e2ids.get(email)) {
                            if (!vis[associatedId]) {
                                vis[associatedId] = true;
                                q.offer(associatedId);
                            }
                        }
                    }
                }
                List<String> sList = new ArrayList<String>();
                sList.add(accounts.get(i).get(0));
                for (String email : emails) {
                    sList.add(email);
                }
                res.add(sList);
            }
        }
        return res;
    }
}