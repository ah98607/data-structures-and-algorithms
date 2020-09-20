class Solution {
    public int[] plusOne(int[] digits) {
        List<Integer> iList = new ArrayList<Integer>();
        int cout = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int tempSum = cout + digits[i];
            iList.add(tempSum % 10);
            cout = tempSum / 10;
        }
        if (cout == 1) {
            iList.add(1);
        }
        int[] result = new int[iList.size()];
        for (int i = 0; i < iList.size(); i++) {
            result[i] = iList.get(iList.size() - 1 - i);
        }
        return result;
    }
}