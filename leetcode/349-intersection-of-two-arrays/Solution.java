class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null && nums2 == null || nums1.length == 0 && nums2.length == 0) {
            return new int[0];
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i1 = 0;
        int i2 = 0;
        List<Integer> iList = new ArrayList<Integer>();
        while (i1 < nums1.length && i2 < nums2.length) {
            if (nums1[i1] == nums2[i2]) {
                iList.add(nums1[i1]);
                do {
                    i1++;
                } while (i1 < nums1.length && nums1[i1] == nums1[i1 - 1]);
                do {
                    i2++;
                } while (i2 < nums2.length && nums2[i2] == nums2[i2 - 1]);
            }
            else if (nums1[i1] < nums2[i2]) {
                i1++;
            }
            else {
                i2++;
            }
        }
        int[] result = new int[iList.size()];
        for (int i = 0; i < iList.size(); i++) {
            result[i] = iList.get(i);
        }
        return result;/*
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[0];
        }
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums1.length; i++) {
            if (!set.contains(nums1[i])) {
                set.add(nums1[i]);
            }
        }
        List<Integer> iList = new ArrayList<Integer>();
        for (int i = 0; i < nums2.length; i++) {
            if (set.contains(nums2[i])) {
                iList.add(nums2[i]);
                set.remove(nums2[i]);
            }
        }
        int[] result = new int[iList.size()];
        for (int i = 0; i < iList.size(); i++) {
            result[i] = iList.get(i);
        }
        return result;*/
    }
}