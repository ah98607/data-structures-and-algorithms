class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (!freq.containsKey(nums[i])) {
                freq.put(nums[i], 1);
            }
            else {
                freq.put(nums[i], 1 + freq.get(nums[i]));
            }
            if (freq.get(nums[i]) > nums.length / 2) {
                return nums[i];
            }
        }
        return -1;
    }
}