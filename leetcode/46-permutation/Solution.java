class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums.length == 0) {
            return res;
        }
        recFind(res, new ArrayList<Integer>(), new boolean[nums.length], nums);
        return res;
    }
    private void recFind(List<List<Integer>> res, List<Integer> iList, boolean[] vis, int[] nums) {
        if (iList.size() == nums.length) {
            res.add(new ArrayList<Integer>(iList));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!vis[i]) {
                iList.add(nums[i]);
                vis[i] = true;
                recFind(res, iList, vis, nums);
                vis[i] = false;
                iList.remove(iList.size() - 1);
            }
        }
    }
}