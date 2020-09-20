class Solution {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }
        Arrays.sort(citations);
        int result = 0;
        for (int i = 0; i < citations.length; i++) {
            result = Math.max(result, Math.min(citations[i], citations.length - i));
        }
        return result;
    }
}