class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] merge = new int[nums1.length + nums2.length];
        int index1 = 0;
        int index2 = 0;
        int index = 0;
        while (index1 < nums1.length && index2 < nums2.length) {
            if (nums1[index1] < nums2[index2]) {
                merge[index++] = nums1[index1++];
            }
            else {
                merge[index++] = nums2[index2++];
            }
        }
        while (index1 < nums1.length) {
            merge[index++] = nums1[index1++];
        }
        while (index2 < nums2.length) {
            merge[index++] = nums2[index2++];
        }
        if ((merge.length & 1) == 1) {
            return merge[merge.length / 2];
        }
        return (merge[merge.length / 2 - 1] + merge[merge.length / 2]) / 2.0;
    }
}