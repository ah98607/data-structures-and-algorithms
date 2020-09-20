class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        if (nums1.length == 0) {
            return new int[0];
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < nums2.length; i++) {
            while (!stack.isEmpty() && nums2[i] > stack.peek()) {
                map.put(stack.pop(), nums2[i]);
            }
            stack.push(nums2[i]);
        }
        int[] res = new int[nums1.length];
        Arrays.fill(res, -1);
        for (int i = 0; i < nums1.length; i++) {
            if (map.containsKey(nums1[i])) {
                res[i] = map.get(nums1[i]);
            }
        }
        return res;
    }
}