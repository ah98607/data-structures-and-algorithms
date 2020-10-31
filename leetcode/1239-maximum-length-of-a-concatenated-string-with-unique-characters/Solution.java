class Solution {
    int maxLen;
    public int maxLength(List<String> arr) {
        if (arr.size() == 0) {
            return 0;
        }
        recFind(0, 0, 0, arr);
        return maxLen;
    }
    private void recFind(int start, int len, int bin, List<String> sList) {
        maxLen = Math.max(maxLen, len);
        for (int i = start; i < sList.size(); i++) {
            int newBin = bin;
            boolean shareChar = false;
            for (int j = 0; j < sList.get(i).length(); j++) {
                if (((newBin >> (sList.get(i).charAt(j) - 'a')) & 1) == 1) {
                    shareChar = true;
                    break;
                }
                newBin |= 1 << (sList.get(i).charAt(j) - 'a');
            }
            if (!shareChar) {
                recFind(i + 1, len + sList.get(i).length(), newBin, sList);
            }
        }
    }
}