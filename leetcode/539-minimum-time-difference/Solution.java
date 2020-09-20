class Solution {
    public int findMinDifference(List<String> timePoints) {
        List<Integer> times = new ArrayList<Integer>();
        for (String time : timePoints) {
            times.add(Integer.parseInt(time.substring(0, 2)) * 60 + Integer.parseInt(time.substring(3)));
        }
        Collections.sort(times);
        int minDiff = Integer.MAX_VALUE;
        for (int i = 1; i < times.size(); i++) {
            minDiff = Math.min(minDiff, times.get(i) - times.get(i - 1));
        }
        int lastDiff = times.get(times.size() - 1) - times.get(0);
        if (lastDiff > 720) {
            lastDiff = 1440 - lastDiff;
        }
        return Math.min(minDiff, lastDiff);
    }
}