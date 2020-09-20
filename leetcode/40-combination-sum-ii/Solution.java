class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (candidates.length == 0) {
            return res;
        }
        Arrays.sort(candidates);
        recFind(res, new ArrayList<Integer>(), 0, target, candidates);
        return res;
    }
    private void recFind(List<List<Integer>> res, List<Integer> iList, int start, int target, int[] nums) {
        if (target <= 0) {
            if (target == 0) {
                res.add(new ArrayList<Integer>(iList));
            }
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            iList.add(nums[i]);
            recFind(res, iList, i + 1, target - nums[i], nums);
            iList.remove(iList.size() - 1);
        }
    }
}