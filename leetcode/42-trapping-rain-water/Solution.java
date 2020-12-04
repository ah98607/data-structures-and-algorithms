class Solution {
    public int trap(int[] height) {
        if (height.length < 3) {
            return 0;
        }
        int v = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            int low = Math.min(height[left], height[right]);
            if (low == height[left]) {
                left++;
                while (left < right && height[left] < low) {
                    v += low - height[left++];
                }
            }
            else {
                right--;
                while (left < right && height[right] < low) {
                    v+= low - height[right--];
                }
            }
        }
        return v;
    }
}