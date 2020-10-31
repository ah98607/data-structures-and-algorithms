class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<String>();
        if (nums.length == 0) {
            return res;
        }
        int start = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1] + 1) {
                if (i - 1 != start) {
                    res.add(nums[start] + "->" + nums[i - 1]);
                }
                else {
                    res.add(String.valueOf(nums[start]));
                }
                start = i;
            }
        }
        if (nums.length - 1 != start) {
            res.add(nums[start] + "->" + nums[nums.length - 1]);
        }
        else {
            res.add(String.valueOf(nums[start]));
        }
        return res;
    }
}