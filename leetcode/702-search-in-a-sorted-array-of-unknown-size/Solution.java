/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class Solution {
    public int search(ArrayReader reader, int target) {
        int left = 0;
        int right = 1;
        while (reader.get(right) < target) {
            right *= 2;
        }
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (target == reader.get(mid)) {
                return mid;
            }
            if (target < reader.get(mid)) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        if (target == reader.get(left)) {
            return left;
        }
        if (target == reader.get(right)) {
            return right;
        }
        return -1;
    }
}