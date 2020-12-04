class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
        for (int i = 0; i <= nums.length; i++) {
            recFind(res, new ArrayList<Integer>(), 0, i, nums);
        }
        return res;
    }
    private void recFind(List<List<Integer>> res, List<Integer> iList, int start, int end, int[] nums) {
        if (start == end) {
            res.add(new ArrayList<Integer>(iList));
        }
        for (int i = start; i < end; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            iList.add(nums[i]);
            recFind(res, iList, i + 1, end, nums);
            iList.remove(iList.size() - 1);
        }
    }
}