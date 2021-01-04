class Solution {
    public int findMinDifference(List<String> timePoints) {
        List<Integer> iList = new ArrayList<Integer>();
        for (int i = 0; i < timePoints.size(); i++) {
            iList.add(Integer.parseInt(timePoints.get(i).substring(0, 2)) * 60 + Integer.parseInt(timePoints.get(i).substring(3)));
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