public class Solution {
    /** 
     *@param L: Given n pieces of wood with length L[i]
     *@param k: An integer
     *return: The maximum length of the small pieces.
     */
    public int woodCut(int[] L, int k) {
        // write your code here
        if (L == null) {
            return 0; // should not be used
        }
        // get the longest wood and use it and initial "right"
        int max = 0;
        for (int i = 0; i < L.length; i++) {
            max = Math.max(max, L[i]);
        }
        int left = 1; // shortest length of a piece of wood
        int right = max;
        int mid = 1;
        int num = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;
            num = numAfterCut(L, mid);
            //System.out.println(mid+", "+num);
            /*if (num == k) { <--- classic mistake !!!
                return mid;
            }*/
            if (num >= k) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        if (numAfterCut(L, left) < k) {
            return left - 1;
        }
        else {
            return left;
        }
    }
    private int numAfterCut(int[] L, int unitLength) {
        if (L == null) {
            return 0; // should not be used
        }
        int num = 0;
        for (int i = 0; i < L.length; i++) {
            num += L[i] / unitLength;
        }
        return num;
    }
}