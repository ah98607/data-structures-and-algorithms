class Solution {
    public int findMinDifference(List<String> timePoints) {
        List<Integer> iList = new ArrayList<Integer>();
        for (String timePoint : timePoints) {
            iList.add(Integer.parseInt(timePoint.substring(0, 2)) * 60 + Integer.parseInt(timePoint.substring(3)));
        }
        Collections.sort(iList);
        int minDiff = Integer.MAX_VALUE;
        for (int i = 1; i < iList.size(); i++) {
            minDiff = Math.min(minDiff, iList.get(i) - iList.get(i - 1));
        }
        int lastDiff = iList.get(iList.size() - 1) - iList.get(0);
        if (lastDiff > 720) {
            lastDiff = 1440 - lastDiff;
        }
        return Math.min(minDiff, lastDiff);
    }
}