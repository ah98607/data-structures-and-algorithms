class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums.length < 3) {
            return res;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            twoSum(res, i, nums);
        }
        return res;
    }
    private void twoSum(List<List<Integer>> res, int start, int[] nums) {
        int left = start + 1;
        int right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (-nums[start] == sum) {
                List<Integer> iList = new ArrayList<Integer>();
                iList.add(nums[start]);
                iList.add(nums[left]);
                iList.add(nums[right]);
                res.add(iList);
                left++;
                while (left < right && nums[left] == nums[left - 1]) {
                    left++;
                }
            }
            else if (-nums[start] > sum) {
                left++;
            }
            else {
                right--;
            }
        }
    }
}