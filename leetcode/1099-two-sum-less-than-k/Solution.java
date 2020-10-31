class Solution {
    public int twoSumLessThanK(int[] A, int K) {
        if (A.length < 2) {
            return -1;
        }
        Arrays.sort(A);
        int left = 0;
        int right = A.length - 1;
        int sum = -1;
        while (left < right) {
            int temp = A[left] + A[right];
            if (temp < K) {
                sum = Math.max(sum, temp);
                left++;
            }
            else {
                right--;
            }
        }
        return sum;
    }
}