class Solution {
    public int findDuplicate(int[] nums) {
        // n vairies from 1 to n, if there is a duplicate number,
        // then in total there are n + 1 numbers.
        // index varies from 0 to n
        int slow = 0;
        int fast = 0;
        while (true) {
            fast = nums[nums[fast]];
            slow = nums[slow];
            if (fast == slow) {
                break;
            }
        }
        fast = 0;
        while (slow != fast) {
            fast = nums[fast];
            slow = nums[slow];
        }
        return fast;
    }
}