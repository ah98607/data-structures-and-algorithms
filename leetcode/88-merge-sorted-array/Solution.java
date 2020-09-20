class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] merge = new int[m + n];
        int index1 = 0;
        int index2 = 0;
        int index = 0;
        while (index1 < m && index2 < n) {
            if (nums1[index1] < nums2[index2]) {
                merge[index++] = nums1[index1++];
            }
            else {
                merge[index++] = nums2[index2++];
            }
        }
        while (index1 < m) {
            merge[index++] = nums1[index1++];
        }
        while (index2 < n) {
            merge[index++] = nums2[index2++];
        }
        for (int i = 0; i < merge.length; i++) {
            nums1[i] = merge[i];
        }
    }
}