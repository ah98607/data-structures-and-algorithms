class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<Integer>();
        for (int i = 1; i <= 9; i++) {
            recFind(res, i, n);
        }
        return res;
    }
    private void recFind(List<Integer> res, int cur, int n) {
        if (cur > n) {
            return;
        }
        res.add(cur);
        for (int i = 0; i <= 9; i++) {
            recFind(res, 10 * cur + i, n);
        }
    }
}