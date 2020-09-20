class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        recFind(res, new ArrayList<Integer>(), 0, n, k);
        return res;
    }
    private void recFind(List<List<Integer>> res, List<Integer> iList, int start, int n, int k) {
        if (iList.size() == k) {
            res.add(new ArrayList<Integer>(iList));
            return;
        }
        for (int i = start; i < n; i++) {
            iList.add(i + 1);
            recFind(res, iList, i + 1, n, k);
            iList.remove(iList.size() - 1);
        }
    }
}