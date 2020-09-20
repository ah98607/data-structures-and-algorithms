class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> iList = new ArrayList<Integer>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    iList.add(1);
                }
                else {
                    iList.add(res.get(res.size() - 1).get(j - 1) + res.get(res.size() - 1).get(j));
                }
            }
            res.add(iList);
        }
        return res;
    }
}