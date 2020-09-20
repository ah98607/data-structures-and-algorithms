class Solution {
    public int[] sortArrayByParity(int[] A) {
        if (A == null || A.length == 0) {
            return new int[0];
        }
        int index = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 0) {
                swap(A, index++, i);
            }
        }
        return A;
    }
    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}