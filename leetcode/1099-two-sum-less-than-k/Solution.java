class Solution {
    public int twoSumLessThanK(int[] A, int K) {
        if (A.length < 2) {
            return -1;
        }
        Arrays.sort(A);
        int left = 0;
        int right = A.length - 1;
        int res = -1;
        while (left < right) {
            int sum = A[left] + A[right];
            if (sum < K) {
                left++;
                res = Math.max(res, sum);
            }
            else {
                right--;
            }
        }
        return res;
    }
}