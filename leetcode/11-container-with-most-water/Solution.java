class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int v = 0;
        while (left < right) {
            int low = Math.min(height[left], height[right]);
            v = Math.max(v, low * (right - left));
            if (low == height[left]) {
                left++;
            }
            else {
                right--;
            }
        }
        return v;
    }
}