class Solution {
    int res;
    public int maxLength(List<String> arr) {
        recFind(0, 0, 0, arr);
        return res;
    }
    private void recFind(int start, int len, int bin, List<String> sList) {
        res = Math.max(res, len);
        for (int i = start; i < sList.size(); i++) {
            int tempBin = bin;
            boolean shareChar = false;
            for (int j = 0; j < sList.get(i).length(); j++) {
                if (((tempBin >> (sList.get(i).charAt(j) - 'a')) & 1) == 1) {
                    shareChar = true;
                    break;
                }
                tempBin |= 1 << (sList.get(i).charAt(j) - 'a');
            }
            if (!shareChar) {
                recFind(i + 1, len + sList.get(i).length(), tempBin, sList);
            }
        }
    }
}