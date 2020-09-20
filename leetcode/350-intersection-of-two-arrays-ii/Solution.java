class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }
        Map<Integer, Integer> freq = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums1.length; i++) {
            if (!freq.containsKey(nums1[i])) {
                freq.put(nums1[i], 1);
            }
            else {
                freq.put(nums1[i], 1 + freq.get(nums1[i]));
            }
        }
        List<Integer> iList = new ArrayList<Integer>();
        for (int i = 0; i < nums2.length; i++) {
            if (freq.containsKey(nums2[i]) && freq.get(nums2[i]) > 0) {
                iList.add(nums2[i]);
                freq.put(nums2[i], freq.get(nums2[i]) - 1);
            }
        }
        int[] res = new int[iList.size()];
        for (int i = 0; i < iList.size(); i++) {
            res[i] = iList.get(i);
        }
        return res;
    }
}