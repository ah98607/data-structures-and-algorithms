class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        recFind(res, new ArrayList<Integer>(), new boolean[nums.length], nums);
        return res;
    }
    private void recFind(List<List<Integer>> res, List<Integer> iList, boolean[] vis, int[] nums) {
        if (iList.size() == nums.length) {
            res.add(new ArrayList<Integer>(iList));
        }
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && vis[i - 1]) {
                continue;
            }
            if (!vis[i]) {
                vis[i] = true;
                iList.add(nums[i]);
                recFind(res, iList, vis, nums);
                iList.remove(iList.size() - 1);
                vis[i] = false;
            }
        }
    }
}