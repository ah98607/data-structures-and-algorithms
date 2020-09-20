class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (candidates == null || candidates.length == 0) {
            return result;
        }
        recFind(result, new ArrayList<Integer>(), candidates, target);
        return result;
    }
    private void recFind(List<List<Integer>> result, List<Integer> iList, int[] candidates, int target) {
        if (target <= 0) {
            if (target == 0) {
                List<Integer> temp = new ArrayList<Integer>(iList);
                Collections.sort(temp);
                if (!result.contains(temp)) {
                    result.add(new ArrayList<Integer>(temp));
                }
            }
            return;
        }
        for (int i = 0; i < candidates.length; i++) {
            if (i > 0 && candidates[i] == candidates[i - 1]) {
                continue;
            }
            iList.add(candidates[i]);
            recFind(result, iList, candidates, target - candidates[i]);
            iList.remove(iList.size() - 1);
        }
    }
}