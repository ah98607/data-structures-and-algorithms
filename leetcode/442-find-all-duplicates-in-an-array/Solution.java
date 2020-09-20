class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                result.add(nums[i]);
            }
            else {
                set.add(nums[i]);
            }
        }
        return result;
    }
}